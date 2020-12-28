;; Type: (list of number) number -> boolean
;; Returns: true if the given number is atleast once in the list
(define (contains-x? nums x)
	(and (not (empty? nums))
		(or (= (first nums) x)
			(contains-x? (rest nums) x))))

;; Tests
(check-expect (contains-x? (list 5.5 5.2 105 2421 2432 54.9) 5) #false)
(check-expect (contains-x? (list 1 5 2 9 8 6 9 2 1 0 9 8 3) 5) #true)
(check-expect (contains-x? (list 5 352 21 432 25 5.2 5.0) 5) #true)