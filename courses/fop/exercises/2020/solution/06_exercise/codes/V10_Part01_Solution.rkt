;; Type: image -> (list of number)
;; Returns: a two element list containing the total number of black and white
;; pixel of the given image
(define (count-black-white img)
	(list
		;; Type: color -> boolean
		;; Returns: true if the red component of a color is zero 
		(length (filter (lambda (x) (= 0 (color-red x))) (image->color-list img)))
		;; Type: color -> boolean
		;; Returns: true if the red component of a color is 255 
		(length (filter (lambda (x) (= 255 (color-red x))) (image->color-list img)))))