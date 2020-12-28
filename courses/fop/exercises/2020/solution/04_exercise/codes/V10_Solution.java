/**
 * Returns an array of a with every third element removed.
 * 
 * @param a array by deleting every third element
 * @return an array of a with every third element removed
 */
public int[] foo(int[] a) {
	int[] b = new int[(int) (a.length - Math.round(a.length / 3.0))];
	for (int i = 0, j = 0; i < a.length; i++)
		if (i % 3 == 0)
			continue;
		else {
			b[j] = a[i];
			j++;
		}
	return b;
}