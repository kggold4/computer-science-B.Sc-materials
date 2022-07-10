#lang pl
(: f : Number -> Number)
(define (f x)
  (if (and (<= 0 x) (<= x 5)) 1 0))

(test (f 0) => 1)
(test (f 1) => 1)
(test (f 2) => 1)
(test (f 3) => 1)
(test (f 4) => 1)
(test (f 5) => 1)
(test (f 6) => 0)
(test (f -1) => 0)