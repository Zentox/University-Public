;; Type: (list of student) -> real
;; Returns: the mean of student ages
(define (mean-of-ages students)
	(local
		(
			;; Type (list of student) natural -> natural
			;; Precondtion: sum must be 0 at the beginning
			;; Returns: the sum of student ages
			(define (sum-age students sum)
				(if (empty? students)
					sum
					(sum-age (rest students)
						(+ sum (person-age (student-person (first student)))))))
		)
	(if (empty? students)
		0
		(/ (sum-age students 0) (length students))))

; Students
(define student1 (make-student (make-person 22 "Männlich") "7874596"))
(define student2 (make-student (make-person 33 "Weiblich") "1529563"))
(define student3 (make-student (make-person 65 "Männlich") "5244253"))
(define student4 (make-student (make-person 43 "Weiblich") "3276122"))
(define student5 (make-student (make-person 18 "Männlich") "1265894"))
(define student6 (make-student (make-person 30 "Weiblich") "1234567"))

;; Tests
(check-expect (mean-of-ages (list student1 student2 student3)) 40)
(check-expect (mean-of-ages empty) 0)
(check-within (mean-of-ages
	(list student1 student2 student3 student4 student5 student6)) 35.16 0.1)