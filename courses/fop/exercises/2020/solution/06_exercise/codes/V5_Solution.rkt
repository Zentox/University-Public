(define (bar1 lst)
	(cond
		[(empty? lst) empty]
		[(abc? (first lst)) (cons (foo (first lst)) (bar1 (rest lst)))]
		[else (bar1 (rest lst))]))