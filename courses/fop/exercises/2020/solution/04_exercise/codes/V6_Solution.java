static int appendIntegers(int[] a) {
	int result = a[0];
	for (int i = 1; i < a.length; i++) {
		result = append(result, a[i]);
	}
	return result;
}

static int append(int x, int y) {
	int d = 1;
	while (y / d != 0) {
		d *= 10;
	}
	return x * d + y;
}