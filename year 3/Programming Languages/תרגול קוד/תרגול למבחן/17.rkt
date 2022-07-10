#lang pl
(: sum-list : (Listof Number) -> Number)
(define (sum-list lst)
  (match lst
    ['() 0]
    [(cons h t) (+ h (sum-list t))]))

(test (sum-list '()) => 0)
(test (sum-list null) => 0)
(test (sum-list '(1)) => 1)
(test (sum-list '(1 2)) => 3)
(test (sum-list '(1 2 3)) => 6)