#lang pl
(: revr : (Listof Any) -> (Listof Any))
(define (revr lst)
  (match lst
    [(or (list) (list _)) lst]
    [(list bs ... a) (cons a (revr bs))]))

(test (revr '(1 2 3)) => '(3 2 1))
(test (revr '(1)) => '(1))
(test (revr null) => null)
(test (revr '()) => null)
(test (revr null) => '())
(test (revr '()) => '())