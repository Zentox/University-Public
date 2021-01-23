/**
 * 
 * @param a     array in which all elements should be sorted which are not
 *              between the specified interval (exclusive)
 * @param lower left interval in which the items should not be sorted between
 *              the left and right intervals (exclusive)
 * @param upper right interval in which the items should not be sorted between
 *              the left and right intervals (exclusive)
 * @return an array in which all elements should be sorted which are not between
 *         the specified interval (exclusive)
 * @throws LowerBiggerThanUpperException if lower is not smaller than upper
 */
public int[] betweenNumbers(int[] a, int lower, int upper) throws LowerBiggerThanUpperException {
	if (lower > upper) {
		throw new LowerBiggerThanUpperException();
	}

	int[] sorted = new int[a.length];
	int size = 0;
	int i = 0;

	for (; i < a.length; i++) {
		// Copy in new array
		sorted[i] = a[i];
		// Compute interval to sort
		if (a[i] <= lower || a[i] >= upper) {
			size++;
		}
		// Sorting
		else if (size > 1) {
			insertionSort(sorted, i - size, i - 1);
			size = 0;
		}
	}
	// Sorting
	if (size > 1) {
		insertionSort(sorted, i - size, i - 1);
	}
	return sorted;
}