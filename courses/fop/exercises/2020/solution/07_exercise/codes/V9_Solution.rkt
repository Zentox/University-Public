;; Type: (list of number) number number -> (list of number)
;; Returns: a list of number in which all elements should be
;; sorted which are not between the specified interval (exclusive)
(define (numbersBetween alon lower upper)
	(local
		(
			;; Type: (list of number) (list of number) (list of number)
			;; -> (list of number)
			;; Returns: a sorted list in descending order
			(define (numbersBetween-sort alon sorted acc)
				(cond
					; Empty list
					[(empty? alon)
						; If acc still contains elements, append it to sorted
						(if (empty? acc)  sorted (append (sort  acc >) sorted))]
					; Element must be greater than lower and smaller than upper
					[(and (< lower (first alon)) (> upper (first alon)))
						; If acc is empty we add the element to sorted, else we add acc
						; sorted in descending order to sorted
						(if (empty? acc)
							(numbersBetween-sort (rest alon) (cons (first alon) sorted) acc)
							(numbersBetween-sort (rest alon) (append (list (first alon))
								(sort acc >)sorted ) empty))]
					; Adding elements to acc
					[else (numbersBetween-sort (rest alon) sorted
						(cons (first alon) acc))])))
		; Error if upper is smaller than lower
		(if (< upper lower)
			(error 'numbersBetween: "Lower cannot be greater than upper!")
			; Returns the list from descending order to ascending order
			(reverse (numbersBetween-sort alon empty empty)))))
			
;; Tests
(check-expect (numbersBetween (list  1 5 3 10 6 2 3 4 5 7 6 7 8 9 2) 0 20)
	(list  1 5 3 10 6 2 3 4 5 7 6 7 8 9 2))
(check-expect (numbersBetween (list 1 5 3 10 6 3 4 2 5 7 6 7 8 9 2) 0 4)
	(list 1 5 3 6 10 3 4 2 5 6 7 7 8 9 2 ))
(check-error (numbersBetween (list  1 5 3 10 6 2 3 4 5 7 6 7 8 9 2 ) 4 3))