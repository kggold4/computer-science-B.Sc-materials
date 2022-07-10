#lang pl
(: list-sum : (Listof Number) -> Number)
(define (list-sum lst)

  (: list-sum-help : (Listof Number) Number -> Number)
  (define (list-sum-help lst sum)
    (if (null? lst) sum (list-sum-help (rest lst) (+ sum (first lst)))))

  (list-sum-help lst 0)
  )

(test (list-sum '(1 2 3)) => 6)
(test (list-sum '(1 1 1)) => 3)
(test (list-sum '(1)) => 1)
(test (list-sum '(5 4 3 2 1)) => 15)
(test (list-sum '(10)) => 10)
(test (list-sum '()) => 0)
(test (list-sum null) => 0)
(test (list-sum '(0)) => 0)
