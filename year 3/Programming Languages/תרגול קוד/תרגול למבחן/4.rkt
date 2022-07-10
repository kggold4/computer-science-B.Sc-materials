#lang pl

(: f : Number -> Number)
(define (f x)
  (cond
    [(and (<= 0 x) (< x 5)) 2]
    [(and (<= 5 x) (< x 10)) 4]
    [(<= 10 x) 7]
    [else (error 'f "The function is not defined in ~s" x)]))

(test (f 0) => 2)
(test (f 5) => 4)
(test (f 10) => 7)
(test (f -1) =error> "The function is not defined in -1")
