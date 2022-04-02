#lang pl
(: list-sum : (Listof Number) -> Number)
(define (list-sum list)
  (if (null? list) 0 (+ (first list) (list-sum (rest list)))))

(test (list-sum '(1 2 3)) => 6)
(test (list-sum (list 15 30 45)) => 90)