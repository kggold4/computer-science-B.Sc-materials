#lang pl
(: factorial : Number -> Number)
(define (factorial n)
  (if (eq? n 0) 1 (* n (factorial (- n 1)))))

(test (factorial 0) => 1)
(test (factorial 1) => 1)
(test (factorial 2) => 2)
(test (factorial 3) => 6)
(test (factorial 4) => 24)
(test (factorial 5) => 120)
(test (factorial 6) => 720)