	/**
	 * Returns {@code true} if the distance between the smallest and the middle
	 * element is as large as the distance between the middle and the largest
	 * element.
	 * 
	 * @param a first integer value to be checked
	 * @param b second integer value to be checked
	 * @param c third integer value to be checked
	 * @return {@code true} if the distance between the smallest and the middle
	 *         element is as large as the distance between the middle and the
	 *         largest element
	 */
	static boolean evenlySpaced(int a, int b, int c) {
		return (2 * a - b - c) * (2 * b - a - c) * (2 * c - a - b) == 0;
	}