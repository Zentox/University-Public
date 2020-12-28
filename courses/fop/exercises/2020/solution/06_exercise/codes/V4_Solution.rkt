;; Type: number -> (number -> number)
;; Returns: a function that takes a number x as input and multiplied by y
(define (z x)
	;; Type: number -> number
	;; Returns: Returns the result of product of parameter y with the stored
	;; value x of the outer procedure
	(lambda (y) (* x y)))