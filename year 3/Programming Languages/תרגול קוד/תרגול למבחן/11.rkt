#lang pl
(: factorial : Natural -> Natural)
(define (factorial n)

  (: factorial-help : Natural Natural -> Natural)
  (define (factorial-help n acc)
    (if (zero? n) acc (factorial-help (- n 1) (* acc n))))

  (factorial-help n 1)
  )

(test (factorial 0) => 1)
(test (factorial 1) => 1)
(test (factorial 2) => 2)
(test (factorial 3) => 6)
(test (factorial 4) => 24)
(test (factorial 5) => 120)
(test (factorial 6) => 720)