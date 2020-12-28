;; Type: number number number number number number -> string
;; Returns: the position of two circles
(define (circles-position x1 y1 r1 x2 y2 r2)
	(cond
		[(< (euclid-difference x1 y1 x2 y2) (abs (- r1 r2))) "Interior"]
		[(< (+ r1 r2) (euclid-difference x1 y1 x2 y2)) "External"]
		[else "Intersect"]))
		
;; Tests
(check-expect (circles-position 4 4 3 2 2 6) "Interior")
(check-expect  (circles-position 1 1 3 3 2 4) "Intersect")
(check-expect  (circles-position 1 1 1 5 5 1) "External")

;; Type: number number number number -> number
;; Returns: the Euclidean distance between two points  
(define (euclid-difference x1 y1 x2 y2)
	(sqrt (+ (* (- x1 x2) (- x1 x2)) (* (- y1 y2) (- y1 y2)))))

;; Tests
(check-within (euclid-difference 1 2 3 4) 2.82 0.1)
(check-within (euclid-difference 3 7 12 6) 9.05 0.1)
(check-within (euclid-difference 32 45 2 3) 51.61 0.1)