;; Type: (list of number) (list of number) -> (list of (list of number))
;; Returns; the cartesian product of two lists
(define (cartesian-product lst1 lst2)
	(foldr
		; merges the list element x with the intermediate
		; list "done"
		(lambda (x done)
			(append
				(map
					; makes a new list element of the current
					; x element from the first list and the
					; element s from the second list
					(lambda (s) (list x s)) lst2) done))
		empty  lst1))