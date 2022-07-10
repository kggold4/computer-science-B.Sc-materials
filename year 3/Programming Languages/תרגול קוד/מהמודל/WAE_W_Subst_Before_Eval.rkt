#lang pl 

(define-type WAE
    [Num  Number]
    [Add  WAE WAE]
    [Sub  WAE WAE]
    [Mul  WAE WAE]
    [Div  WAE WAE]
    [Id   Symbol]
    [With Symbol WAE WAE])


(: parse-sexpr : Sexpr -> WAE)
  ;; to convert s-expressions into WAEs
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
      [(list '+ lhs rhs) (Add (parse-sexpr lhs) (parse-sexpr rhs))]
      [(list '- lhs rhs) (Sub (parse-sexpr lhs) (parse-sexpr rhs))]
      [(list '* lhs rhs) (Mul (parse-sexpr lhs) (parse-sexpr rhs))]
      [(list '/ lhs rhs) (Div (parse-sexpr lhs) (parse-sexpr rhs))]
      [else (error 'parse-sexpr "bad syntax in ~s" sexpr)]))

  
  (: parse : String -> WAE)
  ;; parses a string containing a WAE expression to a WAE AST
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





(: subst : WAE Symbol WAE -> WAE)

(define (subst expr from to)
  (cases expr
    [(Num  n) expr]
    [(Add  l r) (Add (subst l from to) (subst r from to))]
    [(Sub  l r) (Sub (subst l from to) (subst r from to))]
    [(Mul  l r) (Mul (subst l from to) (subst r from to))]
    [(Div  l r) (Div (subst l from to) (subst r from to))]
    [(With name named body) (With name
                                  (subst named from to)
                                  (if (eq? name from)
                                      body
                                      (subst body from to)))]
    [(Id   name) (if (eq? name from) to expr)]))


(test (subst (Mul (Id 'x) (Id 'x)) ;e
       'x ;i
       (Num 6) ;v
       )=>(Mul (Num 6) (Num 6)))

(test (subst  
         (Mul (Id 'x) (Id 'y)) ;; expr 
         'x ;; from
         (Num 5)) => ;; to
                 (Mul (Num 5) (Id 'y)))


(test (subst 
         (With 'x ;; name
               (Num 3) ;; named-expr
               (Add (Id 'x) (Num 5))) ;;body 
         'x ;; from
         (Num 8)) ; to
        => (With 'x 
               (Num 3) 
               (Add (Id 'x) (Num 5))))

(test (subst 
         (With 'x ;; name
               (Add (Id 'x) (Id 'x)) ;; named-expr
               (Add (Id 'x) (Num 5))) ;;body 
         'x ;; from
         (Num 8)) ; to
        => (With 'x 
               (Add (Num 8) (Num 8)) 
               (Add (Id 'x) (Num 5))))

(test (subst 
         (With 'y ;; name
               (Add (Id 'x) (Id' x)) ;; named-expr
               (Add (Id 'x) (Num 5))) ;;body 
         'x ;; from
         (Num 8)) ; to
        => (With 'y 
               (Add (Num 8) (Num 8)) 
               (Add (Num 8) (Num 5))))
