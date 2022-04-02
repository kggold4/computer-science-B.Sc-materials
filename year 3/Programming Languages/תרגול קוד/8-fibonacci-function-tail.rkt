#lang pl
(: fib-tail : Natural -> Natural)
(define (fib-tail n)
  (: fib-tail-help : Natural Natural Natural -> Natural)
  (define (fib-tail-help count f1 f2)
    (if (= n count)
        (+ f1 f2)
        (fib-tail-help (+ count 1) f2 (+ f1 f2))))
  (cond
    [(= n 0) 1]
    [(= n 1) 1]
    [else (fib-tail-help 2 1 1)]))

(fib-tail 10)