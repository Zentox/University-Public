;; Type: image -> image
;; Returns: the negative transformation of the given image back
(define (negative-transformation img)
	(color-list->bitmap
		(map
			;; Type: color -> color
			;; Returns: the negative color of the given color
			(lambda (x)
				(make-color
					(- 255 (color-red x))
					(- 255 (color-green x))
					(- 255 (color-blue x)) 255))
			(image->color-list img))
		(image-width img) (image-height img)))