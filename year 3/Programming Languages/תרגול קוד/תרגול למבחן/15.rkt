#lang pl
(: fib : Natural -> Natural)
(define (fib n)

  (: fib-help : Natural Natural Natural -> Natural)
  (define (fib-help count a b)

    (if (= n count)
        (+ a b)
        (fib-help (+ count 1) b (+ a b))))

  (cond
    [(= n 0) 1]
    [(= n 1) 1]
    [else (fib-help 2 1 1)])

  )


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