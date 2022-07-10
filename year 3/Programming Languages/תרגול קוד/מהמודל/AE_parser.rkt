#lang pl

#|
The AE grammer

  <AE> ::= <num>
           | { + <AE> <AE> }
           | { - <AE> <AE> }
|#
;; Defining the AST -- AE
(define-type AE
  [Num Number]
  [Add AE AE]
  [Sub AE AE])


#|

|#
#|
;; Old version:
(: parse-sexpr : Sexpr -> AE)
(define (parse-sexpr sxp)
  (cond [(number? sxp) (Num sxp)]
        [(and (list? sxp)
              (= (length sxp) 3)
              (eq? (first sxp) '+))
         (Add (parse-sexpr (second sxp))
              (parse-sexpr (third sxp)))]
        [(and (list? sxp)
              (= (length sxp) 3)
              (eq? (first sxp) '-))
         (Sub (parse-sexpr (second sxp))
              (parse-sexpr (third sxp)))]
        [else (error 'parse-sexpr "bad syntax in ~s" sxp)]))

|#

;;New version (Using match):
(: parse-sexpr : Sexpr -> AE)
(define (parse-sexpr sxp)
  (match sxp
    [(number: n) (Num n)]
    [(list '+ l r) (Add (parse-sexpr l)(parse-sexpr r))]
    [(list '- l r) (Sub (parse-sexpr l)(parse-sexpr r))]
    [else (error 'parse-sexpr "bad syntax in ~s" sxp)]))

(: parse : String -> AE)
(define (parse code)
  (parse-sexpr (string->sexpr code)))


(test (parse "4") => (Num 4))
(test (parse "{+ 3 4}") => (Add (Num 3) (Num 4)))
(test (parse "{+ 3 {- 5 4}}") => (Add (Num 3)
                                      (Sub (Num 5)
                                           (Num 4))))
(test (parse "{+ 2 3 4 5}") =error> "bad syntax")



#|
The goal of parse:
Input:  string describing the program
Output: Abstract Syntax Tree (or an exception if the string is not a valid program)
Two main phases:
1. Read -- turn the string into a simple data structure (we will use the Racket type Sexpr).
2. Actual Parsing -- turn an Sexpr into an AST


Definition of the pl type Sexpr:
Basis -- any Number/Symbol is an Sexpr
General -- any list of Sexpr is an Sexpr

|#