#lang pl
(: f : Natural Natural -> Number)
(define (f a b)
  (sqrt (+ (* a a) (* b b))))

(test (f 3 4) => 5)
(test (f 5 12) => 13)
(test (f 8 15) => 17)
