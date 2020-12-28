;; Type: (list of br) -> real
;; Returns: Returns the total fee of books borrowed
(define (fee-total books)
	(foldl + 0
		;; Type: br -> real
		;; Returns: the fee of a book
		(map (lambda (b)
			(if (string=? (br-type b) "Single")
				(* (br-pop b) 1.75)
				1.5))
        books)))