#lang pl

(: isList : Any -> Boolean)
(define (isList lst)
  (if (list? lst) #t #f))

(test (isList '()) => #t)
(test (isList null) => #t)
(test (isList '(1 2 3)) => #t)
(test (isList (cons 1 (cons 2 null))) => #t)
(test (isList 5) => #f)
(test (isList #t) => #f)

(: isPair : Any -> Boolean)
(define (isPair pair)
  (if (pair? pair) #t #f))

(test (isPair 1) => #f)
(test (isPair (cons 1 (cons 2 null))) => #t)
(test (isPair (cons 1 (cons 2 '()))) => #t)
(test (isPair (cons 1 '(1))) => #t)
(test (isPair (cons 1 '(2))) => #t)
(test (isPair (cons 1 '(2 3))) => #t)
(test (isPair (cons 1 '(3))))