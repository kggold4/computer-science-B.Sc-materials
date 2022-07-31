#lang pl
(: sort-list : (Listof Number) -> (Listof Number))
(define (sort-list lst)
  (sort lst <))

(test (sort-list '(5 6 4 3 2 1)) => '(1 2 3 4 5 6))

(: sort-and-combine-two-lists : (Listof Number) (Listof Number) -> (Listof Number))
(define (sort-and-combine-two-lists lst-1 lst-2)
  (sort-list (cons lst-1 lst-2)))

(test (sort-and-combine-two-lists '(5 6 7) '(3 2 1)) => '(1 2 3 5 6 7))
(test (sort-and-combine-two-lists '(2) '(1)) => '(1 2))
(test (sort-and-combine-two-lists '(9 8 7 6 5 4 3 2) '(1)) => '(1 2 3 4 5 6 7 8 9))
(test (sort-and-combine-two-lists '(4 5 6) '(1 2 3)) => '(1 2 3 4 5 6))