char smallestPDT(long n) {
	if (n == (long) (byte) n) {
		return 'b';
	} else if (n == (long) (short) n) {
		return 's';
	} else if (n == (long) (int) n) {
		return 'i';
	}
	return 'l';
}

char[] smallestPDTs(long[] a) {
	char[] result = new char[a.length];
	for (int i = 0; i < result.length; i++) {
		result[i] = smallestPDT(a[i]);
	}
	return result;
}