#lang pl
(: fib : Integer -> Natural)
(define (fib n)
  (cond
    [(= n 0) 1]
    [(= n 1) 1]
    [(>= n 2) (+ (fib (- n 1)) (fib (- n 2)))]
    [else (error 'f "Except Postive Integer got ~s" n)]))

(test (fib 0) => 1)
(test (fib 1) => 1)
(test (fib 2) => 2)
(test (fib 3) => 3)
(test (fib 4) => 5)
(test (fib 5) => 8)
(test (fib 6) => 13)
(test (fib 7) => 21)
(test (fib 8) => 34)
(test (fib 9) => 55)
(test (fib 10) => 89)