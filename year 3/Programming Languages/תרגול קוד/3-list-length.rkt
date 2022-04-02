#lang pl
(: list-length : (Listof Any) -> Natural)
(define (list-length list)
  (cond
    [(eqv? list '()) 0]
    [else (+ 1 (list-length (rest list)))]
    )
  )
(test (list-length (list 1 2 3 4)) => 4)
(test (list-length '(1 2 'a 'b true)) => 5)
(test (list-length null) => 0)
(test (list-length '()) => 0)