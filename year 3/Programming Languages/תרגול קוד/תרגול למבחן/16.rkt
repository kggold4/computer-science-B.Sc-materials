#lang pl
(: f : Number -> Number)
(define (f x)
  (let ([y (* x x)]) (* y (+ y y))))

(test (f 5) => 1250)
(test (f 10) => 20000)