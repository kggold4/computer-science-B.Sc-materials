#lang pl
(: fib : Integer -> Natural)
(define (fib n)
  (cond
    [(= n 0) 1]
    [(= n 1) 1]
    [(>= n 2) (+ (fib (- n 1)) (fib (- n 2)))]
    [else (error 'fib "Expexts [psitive-Integer got ~s" n)]
    ))

(fib 10)