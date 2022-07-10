#lang pl

(define x 32)

(: convert : Number Char -> Number)
(define (convert temp type)
  (cond
    [(eqv? type #\f) (* (- temp x) (/ 5 9))]
    [(eqv? type #\c) (+ (* temp (/ 9 5)) x)]
    [else (error 'f "Given type is not defined ~s" type)]))

(test (convert 60 #\c) => 140)
(test (convert 45 #\f) => (/ 65 9))
(test (convert 50 #\f) => 10)