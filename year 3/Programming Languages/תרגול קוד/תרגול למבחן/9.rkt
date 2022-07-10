#lang pl
(: list-length : (Listof Any) -> Number)
(define (list-length lst)
  (if (eq? lst null) 0 (+ 1 (list-length (rest lst)))))

(test (list-length (list 1 2 3 4 5)) => 5)
(test (list-length '(1 2 3)) => 3)
(test (list-length null) => 0)
(test (list-length '()) => 0)