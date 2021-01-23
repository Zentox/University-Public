/**
 * Repeatedly steps through the array, picking one element from the input data,
 * compares adjacent pairs, moving all element of the sorted array until the
 * picked element is at its correct position.
 * 
 * @param array          unsorted array which should be sorted
 * @param startInclusive minimum range of the array index inclusive
 * @param endInclusive   maximum range of the array index inclusive
 */
private void insertionSort(int[] array, int startInclusive, int endInclusive) {
	for (int j = startInclusive + 1; j <= endInclusive; j++) {
		int key = array[j];
		int i = j - 1;

		while (i >= startInclusive && array[i] > key) {
			array[i + 1] = array[i];
			i--;
		}
		array[i + 1] = key;
	}
}