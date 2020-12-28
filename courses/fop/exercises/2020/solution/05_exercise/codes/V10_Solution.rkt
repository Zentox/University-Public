;; Type: (list of number) -> boolean
;; Returns: true if the same number appears more than once in the list
(define (duplicates? lst) 
	(cond
		[(empty? lst) #false]
		[(contains-x? (rest lst) (first lst)) #true]
		[else (duplicates? (rest lst))]))

;; Tests
(check-expect (duplicates? (list 1 2 3 4 5 6 7 8 9 0)) #false)
(check-expect (duplicates? (list 1 1.1 1.11 1.5 2 2.5 9 4 3 22)) #false)
(check-expect (duplicates? (list 1 1.1 2.2 3 4 5.324 353 123 12 43 1)) #true)