#lang pl
;;316423615 -Orel Rahum
;;2020 home test bc COVID-19 

#| Please complete the missing rules below  
<SOL> :: = { <NumList> }
        |  { scalar-mult <num> <SOL> }
        |  { intersect <SOL> <SOL>}
        |  { union <SOL> <SOL> } 
        |  <id>
        |  { with {<id> <SOL> } <SOL> } ;; this should be a syntactic sugar
        |  { fun { <id> <id> } <SOL> } ;; a function must have exactly two formal parameters
        |  { call-static <SOL> <SOL> <SOL> } ;; extends closure environment
        |  { call-dynamic <SOL> <SOL> <SOL> } ;; extends current environment

<NumList> :: =  λ | <num> <NumList> ;; where λ stands for the empty word, i.e., { } is the empty set

;; where <num> is any expression identified by Racket as a Number
;; and <id> is any expression such that Racket identifies '<id> as a symbol
 
|#


;; -----------------------------------------------------
;; The abstract syntax tree SOL
(define-type SET = (Listof Number))
(define-type SOL

  ;;this fuction make construtors
  ;;I complete the missing parts based on tests
    [Set  SET]
    [Smult Number SOL]
    [Inter SOL SOL]
    [Union SOL SOL]
    [Id    Symbol]
;;    [With  Symbol SOL SOL] -- not to be used, syntactic sugar for ...
    [Fun   Symbol Symbol SOL]
    [CallS SOL SOL SOL]
    [CallD SOL SOL SOL])

;; ----------------------------------------------------
;; Operations on SETs
;; Please complete the missing parts, and add comments (comments should specify 
;; the role of each procedure, but also describe your work process). Keep your code readable. 


;;ismember get number and SET and return true or false if we have this number in my list
;; this code is wrote for us :)

  (: ismember? : Number SET  -> Boolean)
  (define (ismember? n l)
    (cond [(null? l) #f]
          [(= n (first l)) #t]
          [else (ismember? n (rest l))]))

  (test (not (ismember? 1 '(3 4 5))))
  (test (not (ismember? 1 '( 3 2 3 5 6))))
  (test (ismember? 1 '(3 4 5 1 3 4)))
  (test (ismember? 1 '(1)))





;; remove-duplicates get SET and return list without duplicates Numbers
;; for example '(3 4 5 1 3 4)) => '(5 1 3 4))
;; I used with isnumber? fuction :)
  (: remove-duplicates : SET  -> SET)
  (define (remove-duplicates l)
    (cond [(or (null? l) (null? (rest l))) l]
          [(ismember? (first l) (rest l)) (remove-duplicates(rest l))] ;; we check if it is on list, if yes. I remove it from my list :)
          [else (cons (first l) (remove-duplicates (rest l)))]))

(test (remove-duplicates '(3 4 5)) => '(3 4 5))
(test (remove-duplicates '( 3 2 3 5 6)) => '(2 3 5 6))
(test (remove-duplicates '(3 4 5 1 3 4)) => '(5 1 3 4))
(test (remove-duplicates '(1)) => '(1))




;; create-sorted-set get SET and return list without duplicates Numbers and sort by opertor <
;; for example '(3 4 5 1 3 4)) => '( 1 3 4 5))
;; I used with remove-duplicates :)
  (: create-sorted-set : SET -> SET)
  (define (create-sorted-set l)
    (let ([l (remove-duplicates l) ])  (sort l <)))

(test (create-sorted-set '(5 4 3)) => '(3 4 5))
(test (create-sorted-set '( 3 2 3 5 6)) => '(2 3 5 6))
(test (create-sorted-set '(3 4 5 1 3 4)) => '(1 3 4 5))
(test (create-sorted-set '(1)) => '(1))



;; set-union get 2 lists and return one list that append A and B
;; for example '(5 4 3 6) '(5 3)) => '(3 4 5 6))
;; I used with create-sorted-set for remove douplicate and sort list :)

  (: set-union : SET SET -> SET)
  (define (set-union A B)
    (create-sorted-set (append A B ) ))

(test (set-union'(5 4 3) '(5 4 3)) => '(3 4 5))
(test (set-union'(5 4 3 6) '(5 4 3)) => '(3 4 5 6))
(test (set-union'(5 4 3 6) '(5 3)) => '(3 4 5 6))



;; set-intersection get 2 lists and return one list that with all numbers on both lists
;; for example '(5 4 3 6) '(5 3)) => '(3 5))
;; I used with create-sorted-set for remove douplicate and sort list :)

(: set-intersection : SET SET -> SET)
  (define (set-intersection A B)
    (: mem-filter : Number -> Boolean)
    (define (mem-filter n)
      (ismember? n A))
    (create-sorted-set(filter mem-filter B)))

(test (set-intersection '(5 4 3) '(5 4 3)) => '(3 4 5))
(test (set-intersection '(5 4 3 6) '(5 4 3)) => '(3 4 5))
(test (set-intersection '(5 4 3 6) '(5 3)) => '(3 5))
(test (set-intersection '(1 2 3 -1) '(1 -1 3)) => '(-1 1 3))




;; ---------------------------------------------------------
;; Parser
  ;; Please complete the missing parts, and add comments (comments should specify 
;; choices you make, and also describe your work process). Keep your code readable. 
  (: parse-sexpr : Sexpr -> SOL)
  ;; to convert s-expressions into SOLs
  (define (parse-sexpr sexpr)
    (match sexpr
      [(list (number: ns) ...) (Set (create-sorted-set ns) )] ;; sort and remove-duplicates
      [(symbol: name) (Id name)]
      [(cons 'with more)
       (match sexpr
         [(list 'with (list (symbol: name) named) body)
          (CallS (Fun name name (parse-sexpr body)) (parse-sexpr named)(parse-sexpr named))] ;;; there is no With constructor replace with existing constructors
         [else (error 'parse-sexpr "bad `with' syntax in ~s" sexpr)])]
      [(cons 'fun more)
       (match sexpr
         [(list 'fun (list (symbol: name1) (symbol: name2)) body)
          (if (eq? name1 name2)
              (error 'parse-sexpr "`fun' has a duplicate param name in ~s" sexpr) ;; cannot use the same param name twice
              (Fun name1 name2 (parse-sexpr body)))]
         [else (error 'parse-sexpr "bad `fun' syntax in ~s" sexpr)])]
      [(list 'scalar-mult (number: sc) rhs) (Smult sc (parse-sexpr rhs))]
      [(list 'intersect lhs rhs) (Inter (parse-sexpr lhs) (parse-sexpr rhs))]
      [(list 'union lhs rhs) (Union (parse-sexpr lhs) (parse-sexpr rhs))]
      [(list 'call-static fun arg1 arg2) (CallS (parse-sexpr fun)(parse-sexpr arg1)(parse-sexpr arg2))] 
      [(list 'call-dynamic fun arg1 arg2) (CallD (parse-sexpr fun)(parse-sexpr arg1)(parse-sexpr arg2))]
      [else (error 'parse-sexpr "bad syntax in ~s" sexpr)]))

     


  (: parse : String -> SOL)
  ;; parses a string containing a SOL expression to a SOL AST
  (define (parse str)
    (parse-sexpr (string->sexpr str)))


(test (parse "{with y {with {{x x} x} y}}") =error> "bad `with' syntax in")
(test (parse "{a}")=error> "parse-sexpr: bad syntax in") 
(test (parse "{1 2 3  4 1 4  4 2 3 4 1 2 3}") => (Set '(1 2 3 4)))
(test (parse "{union {1 2 3} {4 2 3}}") => (Union (Set '(1 2 3)) (Set '(2 3 4))))
(test (parse "{fun {x x} x}") =error> "parse-sexpr: `fun' has a duplicate param name in (fun (x x) x)")
(test (parse "{intersect {1 2 3} {4 2 3}}") => (Inter (Set '(1 2 3)) (Set '(2 3 4))))
(test (parse "{with {S {intersect {1 2 3} {4 2 3}}}
                 {call-static {fun {x y} {union x S}}
                              {scalar-mult 3 S}
                              {4 5 7 6 9 8 8 8}}}") 
      =>
      (CallS (Fun 'S
                  'S
                  (CallS (Fun 'x 'y (Union (Id 'x) (Id 'S))) 
                         (Smult 3 (Id 'S)) 
                         (Set '(4 5 6 7 8 9))))
             (Inter (Set '(1 2 3)) (Set '(2 3 4)))
             (Inter (Set '(1 2 3)) (Set '(2 3 4)))))

(test (parse "{with {S {intersect {1 2 3} {4 2 3}}}
                 {call-dynamic {fun {x y} {union x S}}
                              {scalar-mult 3 S}
                              {4 5 7 6 9 8 8 8}}}") 
      =>
      (CallS (Fun 'S
                  'S
                  (CallD (Fun 'x 'y (Union (Id 'x) (Id 'S))) 
                         (Smult 3 (Id 'S)) 
                         (Set '(4 5 6 7 8 9))))
             (Inter (Set '(1 2 3)) (Set '(2 3 4)))
             (Inter (Set '(1 2 3)) (Set '(2 3 4)))))


(test (parse "{with {S {intersect {1 2 3} {4 2 3}}}
              {fun {x} S}}")
      =error> "parse-sexpr: bad `fun' syntax in (fun (x) S)") ;; functions require two formal parameters 



;;-----------------------------------------------------
;; Evaluation 
#|
------------------------------------------------------
Evaluation rules:
    ;; Please complete the missing parts in the formal specifications below

    eval({ N1 N2 ... Nl }, env)  =  (sort (create-set (N1 N2 ... Nl)))
                               where create-set removes all duplications from
                              the sequence (list) and sort is a sorting procedure
    eval({scalar-mult K E},env) =   (K*N1 K*N2 ... K*Nl) if (N1 N2 ... Nl) = eval(E,env) is a sorted set AND
                                = error! otherwise (if S is not a sorted set)
    eval({intersect E1 E2},env) = (sort (create-set (set-intersection (eval(E1,env) , eval(E2,env))))
                                    if both E1 and E2 evaluate to sorted sets
                                = error! otherwise
    eval({union E1 E2},env) = (sort (create-set (eval(E1,env) , eval(E2,env))))
                                  if both E1 and E2 evaluate to sorted sets
                             = error! otherwise
    eval({with {x E1} E2},env) = eval(E2,extend(x,eval(E1,env),env))
    eval({fun {x1 x2} E},env)  = <{fun {x1 x2} E}, env>
    eval({call-static E-op E1 E2},env)
             = eval(Ef,extend(x2,eval(E2,env), extend(x1,eval(E1,env),envf)
                               if eval(E-op,env) = <{fun {x1 x2} Ef}, envf>
             = error!          otherwise
    eval({call-dynamic E-op E1 E2},env)
             = eval(Ef,extend(x2,eval(E2,env), extend(x1,eval(E1,env),env)
                               if eval(E-op,env) = <{fun {x1 x2} Ef}, envf>
             = error!          otherwise

|#

;; Types for environments, values, and a lookup function
;;We have defined END
  (define-type ENV
    [EmptyEnv]
    [Extend Symbol VAL ENV])
;;We have defined VAL
  (define-type VAL
    [SetV SET]
    [FunV Symbol Symbol SOL ENV])

;; try find symbol in my list
  (: lookup : Symbol ENV -> VAL)
  (define (lookup name env)
    (cases env
      [(EmptyEnv) (error 'lookup "no binding for ~s" name)]
      [(Extend id val rest-env)
       (if (eq? id name) val (lookup name rest-env))]))

(test (lookup 'x (EmptyEnv)) =error> "lookup: no binding for ")


;; Auxiliary procedures for eval 
;; Please complete the missing parts, and add comments (comments should specify 
;; the role of each procedure, but also describe your work process). Keep your code readable. 


;; fuction to change SetV (VAR) to set (listof)
  (: SetV->set : VAL -> SET)
    (define (SetV->set v)
      (cases v
        [(SetV S) S]
        [else (error 'SetV->set "expects a set, got: ~s" v)]))


(test (SetV->set (FunV 's 'x (parse "{3 4 5}") (EmptyEnv))) =error> "expects a set, got:") 

;; fuction to make scalar-mult I used with map
  (: smult-set : Number VAL -> VAL)
  (define (smult-set n s)
    (: mult-op : Number -> Number)
    (define (mult-op k)
      (* k n))
    (SetV(map mult-op (SetV->set s))))

(test (smult-set 1 (SetV '(3 4 5))) => (SetV '(3 4 5)))
(test (smult-set 2 (SetV '(3 4 5))) => (SetV '(6 8 10)))
;; fuction that get fuction and 2 value and make this fuction on them
;; the fuction take 2 VAL, parse them to SET, make calculate and return VAL
 (: set-op : (SET SET -> SET) VAL VAL -> VAL)
  ;; gets a binary SET operator, and uses it within a SetV
  ;; wrapper
  (define (set-op op val1 val2)
     (SetV (op (SetV->set val1) (SetV->set val2))))

(test (set-op set-union (SetV'(5 4 3)) (SetV'(5 4 3))) => (SetV'(3 4 5)))





;;---------  the eval procedure ------------------------------
;; Please complete the missing parts, and add comments (comments should specify 
;; the choices you make, and also describe your work process). Keep your code readable. 
(: eval : SOL ENV -> VAL)
  ;; evaluates SOL expressions by reducing them to set values
  (define (eval expr env)
    (cases expr
      [(Set S) (SetV S)] ;; to change it to VAL
      [(Smult n set) (smult-set n (eval set env))]
      [(Inter l r) (set-op set-intersection  (eval l env) (eval r env))]
      [(Union l r) (set-op set-union  (eval l env) (eval r env))]
      [(Id name) (lookup name env)]
      [(Fun bound-id1 bound-id2 bound-body)
       (FunV bound-id1 bound-id2 bound-body env)]
      [(CallS fun-expr arg-expr1 arg-expr2)
       (let ([fval (eval fun-expr env)])
         (cases fval
         [(FunV bound-id1 bound-id2 bound-body f-env)
          (eval bound-body
                (Extend bound-id1 (eval arg-expr1 env)
                        (Extend bound-id2 (eval arg-expr2 env) f-env)))]
           [else (error 'eval "`call-static' expects a function, got: ~s"
                              fval)]))]
      [(CallD fun-expr arg-expr1 arg-expr2)
       (let ([fval (eval fun-expr env)])
         (cases fval
         [(FunV bound-id1 bound-id2 bound-body f-env)
          (eval bound-body
                (Extend bound-id1 (eval arg-expr1 env) ;; helped by leason 10 when Eran tell us the different bettween static/dynamic is 2 symbol "f-"
                        (Extend bound-id2 (eval arg-expr2 env) env)))]
           [else (error 'eval "`call-dynamic' expects a function, got: ~s"
                              fval)]))]))








#|
start  of quation 5!



(test (run "{with {p {call-static cons {1 2 3} {4 2 3}}}
{with {foo {fun {x y} {intersect x y}}}
{call-static p foo {}}}}")
=> '(2 3))


(run "{with {cons {fun {f s} < -- fill in -- >}}
cons}")
(run "{with {first {fun {p spare-param}
{call-< -- fill in -- >}}}
first}")
(run "{with {second < -- fill in -- >
{< -- fill in -- > p {fun {a b} b} {}}}}
second}")


  (: createGlobalEnv : -> ENV)
  (define (createGlobalEnv)
    (Extend 'second <-- fill in -->
            (Extend <-- fill in -->
                    (Extend <-- fill in --> 
                                    (EmptyEnv)))))
|#

  (: run : String -> (U SET VAL))
  ;; evaluate a SOL program contained in a string
  (define (run str)
    (let ([result (eval (parse str) (EmptyEnv))])
       (cases result
         [(SetV S) S]
         [else result])))

(test (run "{call-dynamic {1} {2 2} {}}")
      =error> "eval: `call-dynamic' expects a function, got: #(struct:SetV (1))")
(test (run "{call-static {1} {2 2} {}}")
      =error> "eval: `call-static' expects a function, got: #(struct:SetV (1))")

(test (run "{fun {x y} {union x y}}")=>(FunV 'x 'y (Union (Id 'x) (Id 'y)) (EmptyEnv)))
(test (run "{fun {x x} x}") =error> "parse-sexpr: `fun' has a duplicate param name in (fun (x x) x)")
(test (run "{1 2 3  4 1 4  4 2 3 4 1 2 3}") => '(1 2 3 4))
(test (run "{union {1 2 3} {4 2 3}}") => '(1 2 3 4))
(test (run "{intersect {1 2 3} {4 2 3}}") => '( 2 3))
(test (run "{with {S {intersect {1 2 3} {4 2 3}}}
                 {call-static {fun {x y} {union x S}}
                              {scalar-mult 3 S}
                              {4 5 7 6 9 8 8 8}}}")
      => '(2 3 6 9))
(test (run "{with {S {intersect {1 2 3} {4 2 3}}}
                 {call-dynamic {fun {x y} {union x S}}
                              {scalar-mult 3 S}
                              {4 5 7 6 9 8 8 8}}}")
      => '(2 3 6 9))
(test (run "{with {S {intersect {1 2 3} {4 2 3}}}
                 {call-static {fun {x y} {union x y}}
                              {scalar-mult 3 S}
                              {4 5 7 6 9 8 8 8}}}")
      => '(4 5 6 7 8 9))
#|
(test (run "{with {p {call-static cons {1 2 3} {4 2 3}}}
              {with {S {intersect {call-static first p {}}
                                  {call-static second p {}}}}
                 {call-static {fun {x y} {union x S}}
                              {scalar-mult 3 S}
                              {4 5 7 6 9 8 8 8}}}}")
      =>  '(2 3 6 9))
(test (run "{fun {x x} x}") =error> "parse-sexpr: `fun' has a duplicate param name in (fun (x x) x)")

(test (run "{with {p {call-dynamic cons {1 2 3} {4 2 3}}}
              {with {S {intersect {call-dynamic first p {}}
                                  {call-dynamic second p {}}}}
                 {call-dynamic {fun {x y} {union x S}}
                              {scalar-mult 3 S}
                              {4 5 7 6 9 8 8 8}}}}")
      =>  '(2 3 6 9))
(test (run "{call-static {1} {2 2} {}}")
      =error> "eval: `call-static' expects a function, got: #(struct:SetV (1))")


|#

#|
Answers for part 6:
its really hard for me to answer in English , I will try my best

1. I used Summaries , record leasons (10-12) ,   https://docs.racket-lang.org/ , to be horest it was very hard test for me and take me most of the day.

2.
SET => Listof Number
SOL => Language for group therapy
ENV => contains the extension of the environment
VAL => have set or fuction
its all our defined-type. I explain them in few words

3.first . I used In the presentations of the exercises. then I call 2 time for arg symbol to fit our fun.
I used call static bc the programmer cannot change the val after the fuction is defined. 

4. I dont used with Tail Recursion bc I try make the code like the template we got from you.
   in a second thought , I need used more Tail Recursion bc its effective.
   in tail recursion we dont need to wait until we done all call. we every time send to help-fuc with the temp result.
  and we have less calls on stuck

5.....


6. if we change 1 of our use from call static to call dynamic.
the test will still run and pass . its not ok

|#