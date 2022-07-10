#lang pl
(: addOne : Number -> Number)
(define (addOne n)
  (+ n 1))

(test (addOne 5) => 6)
(test (addOne 6) => 7)
(test (addOne 0) => 1)