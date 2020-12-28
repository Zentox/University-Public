;; Type natural natural -> natural
;; Returns the euclid of the two given numbers
(define (euclid a b)
	(cond 
		[(= 0 a) b]
		[(= 0 b) a]
		[(> a b) (euclid (- a b) b)]
		[else (euclid a (- b a))]))
		
;; Tests
(check-expect (euclid 21 2) 1)
(check-expect (euclid 55 20) 5)
(check-expect (euclid 3 123456789) 3)