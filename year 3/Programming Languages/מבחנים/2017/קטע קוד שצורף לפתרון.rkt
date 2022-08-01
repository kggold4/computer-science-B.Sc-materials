;; The Flang interpreter, using environments

#lang pl

;; RegE abstract syntax trees  
(define-type RegE
    [Reg  (Listof Number)]
    [Add  RegE RegE]
    [Exp  Integer RegE] 
    [Id   Symbol]
    [With Symbol RegE RegE]
    [Fun  Symbol RegE]
    [Call RegE RegE])


(: parse-sexpr : Sexpr -> RegE)
  ;; to convert s-expressions into RegEs
  (define (parse-sexpr sexpr)
    (match sexpr
      [(list 'reg-len '= (number: len) reg-sexpr)
       (if (< len 1) ;; we do not allow empty registers
           (error 'parse-sexpr "Register length must be at least 1")
           (parse-sexpr-RegL reg-sexpr len))] 
      [else (error 'parse-sexpr "bad syntax in ~s" sexpr)]))      

       
(: parse-sexpr-RegL : Sexpr Number -> RegE)
  ;; to convert s-expressions into RegEs
  (define (parse-sexpr-RegL sexpr reg-len)
    (match sexpr
      [(list (number: ns) ... ) 
       (if (= (length ns) reg-len) ;; verifying length
           (Reg ns)
           (error 'parse-sexpr "wrong number of elements in ~s" sexpr))] ; מהי ההודעה המתאימה? 
      [(list 'add lreg rreg) (Add (parse-sexpr-RegL lreg reg-len) (parse-sexpr-RegL rreg reg-len))]
      [(list 'exp (integer: num) reg) (Exp num (parse-sexpr-RegL reg reg-len))]
      [(symbol: name) (Id name)] 
      [(cons 'with more)
       (match sexpr
         [(list 'with (list (symbol: name) named) body)
          (With name 
                (parse-sexpr-RegL named reg-len) 
                (parse-sexpr-RegL body reg-len))]
         [else (error 'parse-sexpr "bad `with' syntax in ~s" sexpr)])]
      [(cons 'fun more)
       (match sexpr
         [(list 'fun (list (symbol: name)) body)
          (Fun name (parse-sexpr-RegL body reg-len))]
         [else (error 'parse-sexpr "bad `fun' syntax in ~s" sexpr)])]
      [(list 'call fun arg) (Call (parse-sexpr-RegL fun reg-len) (parse-sexpr-RegL arg reg-len))]
      [else (error 'parse-sexpr "bad syntax in ~s" sexpr)]))

(: parse : String -> RegE) 
  ;; parses a string containing a RegE expression to a RegE AST
  (define (parse str)
    (parse-sexpr (string->sexpr str)))


(define-type ENV
    [EmptyEnv]
    [Extend Symbol VAL ENV])

  (define-type VAL
    [RegV (Listof Number)]
    [FunV Symbol RegE ENV])

  (: lookup : Symbol ENV -> VAL)
  (define (lookup name env)
    (cases env
      [(EmptyEnv) (error 'lookup "no binding for ~s" name)]
      [(Extend id val rest-env)
       (if (eq? id name) val (lookup name rest-env))]))
   
(: RegV->ListofNumber : VAL -> (Listof Number))
     ;; Consumes a VAL, verifies it is a RegV,  
     ;; and returns the number-list obtained wrapped therein.
    (define(RegV->ListofNumber v)
      (cases v
        [(RegV ns) ns]
        [else (error 'arith-op "expects a list of numbers, got: ~s" v)]))

(: createPowerRaiser : Integer -> (Number -> Number))
   (define (createPowerRaiser y)
    (: powery : Number -> Number)
     (define (powery x)
       (expt x y))
    powery)

(: reg-arith-op : (Number Number -> Number) VAL VAL -> VAL)
    ;; Consumes two registers and some binary numeric operation 'op',  
    ;; and returns the register obtained by applying op on the 
    ;; i'th element of both registers for all i.
(define (reg-arith-op op reg1 reg2)
  (RegV (map op (RegV->ListofNumber reg1) (RegV->ListofNumber reg2))))

(: eval : RegE ENV -> VAL)
  ;; evaluates RegE expressions by reducing them to bit-lists
  (define (eval expr env)
    (cases expr
      [(Reg n) (RegV n)]
      [(Add l r) (let ([lval (eval l env)])
                   (cases lval
                     [(RegV n) (let ([rval (eval r env)])
                                  (cases rval
                                    [(RegV n) (reg-arith-op + (eval l env) (eval r env))]
                                    [else (error 'eval "expects a list of numbers, got: ~s" rval)]
                                  ))]
                     [else (error 'eval "expects a list of numbers, got: ~s" lval)]))]
      [(Exp n reg) (RegV (map (createPowerRaiser n) (RegV->ListofNumber (eval reg env))))]
      [(With bound-id named-expr bound-body)
       (eval bound-body 
             (Extend bound-id (eval named-expr env) env))]
      [(Id name) (lookup name env)]
      [(Fun bound-id bound-body)
       (FunV bound-id bound-body env)]
      [(Call fun-expr arg-expr)
       (let ([fval (eval fun-expr env)])
         (cases fval
           [(FunV bound-id bound-body f-env)
            (eval bound-body
                  (Extend bound-id (eval arg-expr env) f-env))]
           [else (error 'eval "`call' expects a function, got: ~s"
                              fval)]))]))


(: run : String -> (U (Listof Number) Symbol))
  ;; evaluate a ROL program contained in a string
  (define (run str)
    (RegV->ListofNumber (eval (parse str) (EmptyEnv))))


;; tests
  (test (run "{ reg-len =  4  {1 5 88 0}}") => '(1 5 88 0))
  (test (run "{ reg-len =  4  {exp 4 {1 0 0 0}}}") => '(1 0 0 0)) 
  (test (run "{ reg-len =  3  {add {1 2 3} {4 5 6}}}") => '(5 7 9))
  (test (run "{ reg-len =  4  {exp 2 {2 1 4 5}}}") => '(4 1 16 25))

  (test (run "{ reg-len =  2  {with {x {exp 3 {2 5}}}
                                 {call {fun {y} {add x y}}
                                       {2 1}}}}") => '(10 126))
 (test (run "{ reg-len =  2  {with {x {exp 3 {2 5}}}
                                 {fun {y} {add x y}}}}") => 'procedure)
(test (run "{ reg-len =  3  {add {exp 3 {1 2 3}}
                                   {exp 2 {4 5 6}}}}") => '(17 33 63))
   

(test (run "{ reg-len =  2  {with {x {exp 3 {2 5}}}
                                 {call {fun {y} {add x y}}
                                       {2 1 4 5}}}}")
        =error> "parse-sexpr: wrong number of elements in (2 1 4 5)") 
(test (run "{ reg-len =  3  {add {1 2 3} {fun {x} x}}}")
   =error> 
   "eval: expects a list of numbers, got: (FunV x (Id x) (EmptyEnv))") 
(test  (run "{ reg-len =  4  {exp {1 2 3 7} {2 1 4 5}}}")
   =error> "parse-sexpr: bad syntax in (exp (1 2 3 7) (2 1 4 5))")

