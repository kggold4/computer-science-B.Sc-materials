#lang pl
(: f : (Listof Any) -> Number)
(define (f lst)

  (: help : (Listof Any) Symbol -> Number)
  (define (help lst s)
    (match lst
      ['() 0]
      [(list (number: n) x ...)
       (match s
         ['+ (+ (help x s) n)]
         ['- (- (help x s) n)]
         )]
      [(list (symbol: op) x ...) (help x op)]))
  (help lst '+)
  )

(test (f '(1 + 2 - 3 + 4 + 5 - 6)) => 3)