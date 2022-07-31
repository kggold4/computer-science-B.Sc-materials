#lang pl

(: min : Number Number -> Number)
(define (min a b)
  (if (< a b) a b))

(test (min 0 1) => 0)
(test (min 1 2) => 1)
(test (min 12 7) => 7)
(test (min 3 -3) => -3)
(test (min 19 20) => 19)
(test (min 0 0) => 0)

(: max : Number Number -> Number)
(define (max a b)
  (if (> a b) a b))

(test (max 0 1) => 1)
(test (max 1 2) => 2)
(test (max 12 7) => 12)
(test (max 3 -3) => 3)
(test (max 19 20) => 20)
(test (max 0 0) => 0)

(define MAX-INF 999)
(define MIN-INF -999)

(: min-list : (Listof Number) -> Number)
(define (min-list lst)
  (: helper : (Listof Number) Number -> Number)
  (define (helper lst min-num)
    (if (null? lst) min-num (helper (rest lst) (min min-num (first lst)))))
  (helper lst MAX-INF))

(test (min-list '(1 2 3)) => 1)
(test (min-list '(2 1 0)) => 0)
(test (min-list '(7 7 7 7 7 7)) => 7)
(test (min-list '(9 2 8 3 7 6 4 5)) => 2)
(test (min-list '(9 9 9 -9 9 9)) => -9)

(: max-list : (Listof Number) -> Number)
(define (max-list lst)
  (: helper : (Listof Number) Number -> Number)
  (define (helper lst max-num)
    (if (null? lst) max-num (helper (rest lst) (max max-num (first lst)))))
  (helper lst MIN-INF))

(test (max-list '(1 2 3)) => 3)
(test (max-list '(2 1 0)) => 2)
(test (max-list '(7 7 7 7 7 7)) => 7)
(test (max-list '(9 2 8 3 7 6 4 5)) => 9)
(test (max-list '(9 9 9 -9 9 9)) => 9)


(: min-max : (Listof Number) -> (Listof Number))
(define (min-max lst)
  (list (min-list lst) (max-list lst)))

(test (min-max '(4 5 6 8 7 9 1 2 3)) => '(1 9))
(test (min-max '(5 5 5 5 5)) => '(5 5))
(test (min-max '(9 8 7)) => '(7 9))
(test (min-max '(9 8 7 6 5 4 3 2 1)) => '(1 9))
(test (min-max '(1 2 3 4 5 6 7 8 9)) => '(1 9))
(test (min-max '(0)) => '(0 0))
(test (min-max '()) => '(999 -999))