#lang pl
(: factorial : Natural -> Natural)
(define (factorial n)
  (if (zero? n) 1 (* n (factorial (- n 1)))))

(test (factorial 1) => 1)
(test (factorial 2) => 2)
(test (factorial 3) => 6)
(test (factorial 4) => 24)
(test (factorial 5) => 120)
(test (factorial 6) => 720)