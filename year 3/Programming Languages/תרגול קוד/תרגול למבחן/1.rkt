#lang pl
(: Not : Bool -> Bool)
(define (Not a)
  (cond
    [a #f]
    [else #t]))