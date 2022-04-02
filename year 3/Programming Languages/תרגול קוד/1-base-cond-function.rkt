#lang pl
(: f : Number Number -> Number)
(define (f x y)
  (cond
    [(or (< x 0) (< y 0)) -4]
    [else (sqrt (+ (* x x) (* y y)))]
    ))
(f 3 4)