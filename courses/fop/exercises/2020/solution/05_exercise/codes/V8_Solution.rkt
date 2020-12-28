;; Type: ANY -> boolean | (list of ANY (list of ANY))
;; Returns: Returns a list with the first field of the input and the second
;; field if the input is a struct of abc and the second field is a list
(define (foo p)
	(if (and (abc? p) (list? (abc-b p)))
		(list (abc-a p) (abc-b p))
		#false))

;; Tests
(check-expect (foo (make-abc 232 (list 439 (list "XY"))))
	(list 232 (list 439 (list "XY"))))
(check-expect (foo (make-abc 232 41241)) #false)
(check-expect (foo "Test") #false)