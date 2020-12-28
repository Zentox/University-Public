;; Type: (list of ANY) (list of ANY) -> (list of (list of ANY))
;; Returns: a list of ordered pairs from two lists of equal length
(define (zip list1 list2)
	(map list list1 list2))

;; Tests
(check-expect (zip (list "a" "b")(list 1 2)) (list (list "a" 1) (list "b" 2)))
(check-expect (zip (list 23 213 321 21 31221 05438)(list "a" "b" "c" "d" "e" "f"))
	(list (list 23 "a") (list 213 "b") (list 321 "c")
		(list 21 "d") (list 31221 "e") (list 5438 "f")))
(check-expect (zip (list 4) (list 2)) (list (list 4 2)))