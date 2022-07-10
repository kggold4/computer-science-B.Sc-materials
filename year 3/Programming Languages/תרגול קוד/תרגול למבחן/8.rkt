#lang pl
(: list-length : (Listof Any) -> Number)
(define (list-length lst)
  (: list-length-help : (Listof Any) Number -> Number)
  (define (list-length-help lst n)
    (cond
      [(eq? lst null) n]
      [else (list-length-help (rest lst) (+ n 1))]))
  (list-length-help lst 0)
  )

(test (list-length (list 1 2 3 4 5)) => 5)
(test (list-length '(1 2 3)) => 3)
(test (list-length null) => 0)
(test (list-length '()) => 0)