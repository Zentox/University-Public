;; Type: real -> real
;; Returns: the Fahrenheit value in Celsius
(define (fahr->cel degree)
	(* (- degree 32) (/ 5 9)))
	
;; Tests
(check-expect (fahr->cel 32) 0)
(check-within (fahr->cel 0) -17.77 0.1)
(check-within (fahr->cel 255) 123.889  0.1)