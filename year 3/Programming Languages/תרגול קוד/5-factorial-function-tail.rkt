#lang pl

(: helper : Natural Natural -> Natural)
(define (helper n acc)
  (if (zero? n) acc (helper (- n 1) (* acc n))))

(: factorial : Natural -> Natural)
(define (factorial n)
  (helper n 1))

(test (factorial 1) => 1)
(test (factorial 2) => 2)
(test (factorial 3) => 6)
(test (factorial 4) => 24)
(test (factorial 5) => 120)
(test (factorial 6) => 720)