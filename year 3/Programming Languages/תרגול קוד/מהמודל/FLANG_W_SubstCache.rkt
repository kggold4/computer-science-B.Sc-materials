#lang pl 
#|BNF
The FLANG grammer

  <FLANG> ::= <num> 1
           | { + <FLANG> <FLANG> } 2 
           | { - <FLANG> <FLANG> } 3
           | { * <FLANG> <FLANG> } 4
           | { / <FLANG> <FLANG> } 5
           | { with {<id> <FLANG>} <FLANG>} 6
           | <id> 7
           | { fun {<id>} <FLANG> } 8
           | { call <FLANG> <FLANG> } 9

Where <id> refers to any valid symbol in Racket, and <num> colud be any Number in Racket.
|#


(define-type FLANG
    [Num  Number]
    [Add  FLANG FLANG]
    [Sub  FLANG FLANG]
    [Mul  FLANG FLANG]
    [Div  FLANG FLANG]
    [With Symbol FLANG FLANG]
    [Fun Symbol FLANG]
    [Call FLANG FLANG]
    [Id   Symbol])

#|
{fun {x} {* x x}}

{call {fun {x}
           {* x x}}
      {+ 4 3}}

{with {sqr {fun {x} {* x x}}}
      {+ {call sqr 5}
         {call sqr 8}}}
|#

(: parse-sexpr : Sexpr -> FLANG)
  ;; to convert s-expressions into FLANGs
  (define (parse-sexpr sexpr)
    (match sexpr
      [(number: n)    (Num n)]
      [(symbol: name) (Id name)]
      [(cons 'with more)
       ;; go in here for all sexpr that begin with a 'with
       (match sexpr
         [(list 'with (list (symbol: name) named) body)
          (With name (parse-sexpr named) (parse-sexpr body))]
         [else (error 'parse-sexpr "bad `with' syntax in ~s" sexpr)])]
      [(cons 'fun more)
       ;; go in here for all sexpr that begin with a 'fun
       (match sexpr
         [(list 'fun (list (symbol: name)) body)
          (Fun name (parse-sexpr body))]
         [else (error 'parse-sexpr "bad syntax in ~s" sexpr)])]
      [(list 'call fun-expr arg-expr)
                                     (Call (parse-sexpr fun-expr) (parse-sexpr arg-expr))]
      [(list '+ lhs rhs) (Add (parse-sexpr lhs) (parse-sexpr rhs))]
      [(list '- lhs rhs) (Sub (parse-sexpr lhs) (parse-sexpr rhs))]
      [(list '* lhs rhs) (Mul (parse-sexpr lhs) (parse-sexpr rhs))]
      [(list '/ lhs rhs) (Div (parse-sexpr lhs) (parse-sexpr rhs))]
      [else (error 'parse-sexpr "bad syntax in ~s" sexpr)]))

  
  (: parse : String -> FLANG)
  ;; parses a string containing a FLANG expression to a FLANG AST
  (define (parse str)
    (parse-sexpr (string->sexpr str)))

(test (parse "{ + 3  4 }") => (Add (Num 3)
                                   (Num 4)))
(test (parse "3") => (Num 3))
(test (parse "{ + {- 3 2}  4 }") => (Add (Sub (Num 3)
                                              (Num 2))
                                         (Num 4)))
(test (parse "{+ 1 2 3 4}") =error> "bad syntax")

(test (parse "{with {x {+ 4 2}}
      {* x x}}") => (With 'x
                          (Add (Num 4) (Num 2))
                          (Mul (Id 'x) (Id 'x))))
(test (parse "{with {x {+ 5 5}}
                 {with {y {- x 3}}
                    {+ x y}}}")=>(With 'x (Add (Num 5) (Num 5))
                                       (With 'y (Sub (Id 'x) (Num 3))
                                             (Add (Id 'x) (Id 'y)))))

(test (parse "{fun {x} x}") => (Fun 'x (Id 'x)))
(test (parse "{fun {x} {/ x 5}}") => (Fun 'x (Div (Id 'x) (Num 5))))
(test (parse "{call {fun {x} {/ x 5}} 8}") => (Call (Fun 'x (Div (Id 'x) (Num 5))) (Num 8)))
(test (parse "{with {sqr {fun {x} {* x x}}}
      {+ {call sqr 5}
         {call sqr 8}}}") => (With 'sqr
                                   (Fun 'x (Mul (Id 'x) (Id 'x)))
                                   (Add (Call (Id 'sqr) (Num 5))
                                        (Call (Id 'sqr) (Num 8)))))
(test (parse "{fun x x}") =error> "bad syntax")
#|
====
eval({with {x E1} E2}):

1. v <- eval(E1)
2. E2' <- subst(E2, x, v)
3. eval(E2')
======
1)
e[v/i] = To substitute an identifier 'i' in an expression 'e' with an expression 'v',
replace all identifiers in 'e' that have the same name 'i' with the expression 'v'.

Examples:
1. {with {x 6} {* x x}} ==> i=x, e={* x x}, v=6
e[v/i] = {* 6 6}
2. {with {x 6} {* 7 8}} ==> i=x, e={* 7 8}, v=6
e[v/i] = {* 7 8}
3. {with {x 6} {+ x {with {x 3} 10}}} ==> i=x, e={+ x {with {x 3} 10}}, v=6
e[v/i] = {+ 6 {with {6 3} 10}}
======

1. Binding instance
2. Scope
3. Bound instance
4. free instance
====
2)
e[v/i] = To substitute an identifier 'i' in an expression 'e' with an expression 'v',
replace all identifiers in 'e' that have the same name 'i',that are not themselves binding instances,
and that are not in any nested scope of 'i' with the expression 'v'.

Examples:
1. {with {x 6} {* x x}} ==> i=x, e={* x x}, v=6
e[v/i] = {* 6 6}
2. {with {x 6} {* 7 8}} ==> i=x, e={* 7 8}, v=6
e[v/i] = {* 7 8}
3. {with {x 6} {+ x {with {x 3} 10}}} ==> i=x, e={+ x {with {x 3} 10}}, v=6
e[v/i] = {+ 6 {with {x 3} 10}}
4. {with {x 6} {+ x {with {x 3} x}}} ==> i=x, e={+ x {with {x 3} x}}, v=6
e[v/i] = {+ 6 {with {x 3} x}} good
5. {with {x 6} {+ x {with {y 3} x}}} ==> i=x, e={+ x {with {y 3} x}}, v=6
e[v/i] = {+ 6 {with {y 3} x}}
===
3)e[v/i] = To substitute an identifier 'i' in an expression 'e' with an expression 'v',
replace all instances of 'i' that are free in 'e' with an expression 'v'.

1. {with {x 6} {* x x}} ==> i=x, e={* x x}, v=6
e[v/i] = {* 6 6}
2. {with {x 6} {* 7 8}} ==> i=x, e={* 7 8}, v=6
e[v/i] = {* 7 8}
3. {with {x 6} {+ x {with {x 3} 10}}} ==> i=x, e={+ x {with {x 3} 10}}, v=6
e[v/i] = {+ 6 {with {x 3} 10}}
4. {with {x 6} {+ x {with {x 3} x}}} ==> i=x, e={+ x {with {x 3} x}}, v=6
e[v/i] = {+ 6 {with {x 3} x}} good
5. {with {x 6} {+ x {with {y 3} x}}} ==> i=x, e={+ x {with {y 3} x}}, v=6
e[v/i] = {+ 6 {with {y 3} 6}}|#


#|
1.  {+ E1 E2}[v\x]        = {+ E1[v\x] E2[v\x]}
2.  {- E1 E2}[v\x]        = {- E1[v\x] E2[v\x]}
3.  {* E1 E2}[v\x]        = {* E1[v\x] E2[v\x]}
4.  {/ E1 E2}[v\x]        = {/ E1[v\x] E2[v\x]}
5.  y[v\x]                = y
6.  x[v\x]                = v
7.  {with {y E1} E2}[v\x] = {with {y E1[v\x]} E2[v\x]}
8.  {with {x E1} E2}[v\x] = {with {x E1[v\x]} E2}
9.  {call E1 E2}[v\x]     = {call E1[v\x] E2[v\x]}
10. {fun {y} E}[v\x]      = {fun {y} E[v\x]}
11. {fun {x} E}[v\x]      = {fun {x} E}
|#






#|
{with {x {+ 3 2}} []
      {with {y {+ 4 5}} [(x 5)]
            {with {z {+ y = 9  1}} [(y 9) (x 5)]
                  {with {w 8}  [(z 10) (y 9) (x 5)]
                        {- y = 9  {* z = 10  {/ w = 8 7}}}}}}} [(w 8) (z 10) (y 9) (x 5)]


{with {x {+ 3 2}} []
      {+ {with {y {+ 4 5}} [(x 5)] 
            {with {z {+ y = 9 1}} [(y 9)(x 5)]
                  {with {x 8} [(z 10) (y 9)(x 5)]
                        {- y = 9  {* z = 10   {/ x = 8 7}}}}}} [(x 8) (z 10) (y 9) (x 5)]
          x = 5}} [(x 5)] 

|#




(define-type SubstCache = (Listof (List Symbol FLANG)))
(: empty-subst : SubstCache)
(define empty-subst null)


(: extend : Symbol FLANG SubstCache -> SubstCache)
(define (extend id expr sc)
  (cons (list id expr) sc))

(: lookup : Symbol SubstCache -> FLANG)
(define (lookup name sc)
  (let ([cell (assq name sc)])
    (if cell
        (second cell)
        (error 'lookup "free instance ~s" name))))

(test (lookup 'x
              (extend 'y
                      (Num 5)
                      (extend 'x
                              (Num 33)
                              (extend 'foo
                                      (Fun 'x (Id 'x))
                                      (extend 'w (Num 5)
                                              empty-subst))))) => (Num 33))



#|
Formal specifications of eval:

1. eval(N, sc) = N
2. eval({+ E1 E2}, sc) = if eval(E1, sc), eval(E2, sc) return numbers
                                 eval(E1, sc) + eval(E2, sc)
                            otherwise: error!
3. eval({- E1 E2}, sc) = if eval(E1, sc), eval(E2, sc) return numbers
                                 eval(E1, sc) - eval(E2, sc)
                            otherwise: error!
4. eval({* E1 E2}, sc) = if eval(E1, sc), eval(E2, sc) return numbers
                                 eval(E1, sc) * eval(E2, sc)
                            otherwise: error!
5. eval({/ E1 E2}, sc) = if eval(E1, sc), eval(E2, sc) return numbers
                                 eval(E1, sc) / eval(E2, sc)
                            otherwise: error!
6. eval(id, sc) = lookup(id,sc)
7. eval({with {x E1} E2}, sc) = eval(E2, extend(x,eval(E1,sc),sc))
8. eval({fun {x} E}, sc) = {fun {x} E}
9. eval({call E1 E2}, sc)= if {fun {x} E}<--eval(E1, sc)
                            eval(E, extend(E2, sc), sc)
                         otherwise: error!

|#

(: arith-op : (Number Number -> Number) FLANG FLANG -> FLANG)
(: Num->Number : FLANG -> Number)
(define (Num->Number arg)
  (cases arg
    [(Num n) n]
    [else (error 'Num->Number "expects a number, got: ~s" arg)]
   ))
(define (arith-op op arg1 arg2)
(Num (op (Num->Number arg1) (Num->Number arg2))))


(: eval : FLANG SubstCache -> FLANG)
(define (eval exp sc)
  (cases exp
    [(Num n) exp]
    [(Add l r)  (arith-op + (eval l sc) (eval r sc))]
    [(Sub l r)  (arith-op - (eval l sc) (eval r sc))]
    [(Div l r)  (arith-op / (eval l sc) (eval r sc))]
    [(Mul l r)  (arith-op * (eval l sc) (eval r sc))]
    [(With name named-expr body)
     (eval body (extend name (eval named-expr sc)
                        sc))]
    [(Id name) (lookup name sc)]
    [(Fun name body) exp]
    [(Call fun-expr arg-expr)
     (let ([fval (eval fun-expr sc)])
       (cases fval
         [(Fun name body) (eval body (extend name
                                             (eval arg-expr sc)
                                             sc))]
         [else (error 'eval "expected a function, got: ~s" fval)]))
     ]
   ))

(: run : String -> Number)
(define (run code)
  (let ([res (eval (parse code) empty-subst)])
    (cases res
      [(Num n) n]
      [else (error 'run "evaluation returned a non-number: ~s" res)]
     )))
(test (run "{with {sqr {fun {x} {* x x}}}
      {+ {call sqr 5}
         {call sqr 6}}}") => 61)
(test (run "{call {with {foo {fun {x} {* x 3}}}
            foo}
      4}") => 12)
(test (run "{call 4 5}") =error> "eval: expected a function, got")
(test (run "{with {sqr {fun {x} {* x x}}}
                 sqr}") =error> "run: evaluation returned a non-number")

(test (run "{with {add3 {fun {x} {+ x 3}}}
      {call add3 1}}") => 4)

(test (run "{with {add3 {fun {x} {+ x 3}}}
      {with {add1 {fun {x} {+ x 1}}}
            {with {x 3}
                  {call add1 {call add3 x}}
             }}}") => 7)
(test (run "{with {identity {fun {x} x}}
      {with {foo {fun {x} {+ x 1}}}
            {call {call identity foo} 123}}}") => 124)





  


