;; Type: (list of number) (list of number) -> number
;; Returns: the dot product of two vectors as list
(define (vec-mult vec1 vec2)
	(foldr + 0 (map * vec1 vec2)))

;; Tests
(check-expect (vec-mult (list 1 2 3) (list 4 5 6)) 32)
(check-expect (vec-mult (list 1 2 3 4 5 6 7 8 9) (list 9 8 7 6 5 4 3 2 1)) 165)
(check-expect (vec-mult (list 213 422 42 312) (list 4324 2131 431 42141))
	14986388)