;; Type: (list of number) (list of (list of number number number))
;; -> (list of number)
;; Returns: a list of matriculation numbers who that receive admission
(define (passed ids points)
	(map first ; use only student ID
		(filter
			;; Type: (list of number number number) -> boolean
			;; Returns:  true if all requirements for admission are met
			(lambda (entry)
				(and (>= (second entry) 50)
				(>= (third entry) 35)
				(>= (fourth entry) 50)
				(>= (+ (second entry) (third entry) (fourth entry)) 180)))
			(map cons ids points))))