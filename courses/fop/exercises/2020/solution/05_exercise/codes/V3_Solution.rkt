;; Type: real -> real
;; Returns: Returns the third power of the given number
(define (pow3 x)
	(* x x x))

;; Tests
(check-expect (pow3 3) 27)
(check-expect (pow3 -10) -1000)
(check-expect (pow3 99) 970299)

(define k (/ (sqrt 2) 12))

;; Type: real -> real
;; Returns: the volume of a tetrahedron
(define (tetrahedron-volume a)
	(* k (pow3 a)))

;; Tests
(check-within (tetrahedron-volume 22) 1254.87 0.1)
(check-within (tetrahedron-volume 4) 7.54 0.1)
(check-within (tetrahedron-volume 54) 18557.31 0.1)