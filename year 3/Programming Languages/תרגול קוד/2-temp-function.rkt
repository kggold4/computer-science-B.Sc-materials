#lang pl
(define BASE_NUM 32)
(define CELSIUS #\c)
(define FAHRENHEIT #\f)
(: convert : Number Char -> Number)
(define (convert temp type)
  (cond
   [(eqv? type FAHRENHEIT) (* (- temp BASE_NUM) (/ 5 9))]
   [(eqv? type CELSIUS) (+ (* temp (/ 9 5)) BASE_NUM)]
   [else 0]
   ))
(test (convert 60 CELSIUS) => 140)
(test (convert 45 FAHRENHEIT) => (/ 65 9))
(test (convert 50 FAHRENHEIT) => 10)