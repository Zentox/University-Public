public static int[] reverseArray(int[] source) throw Exception {
	int length = source.length();
	int[] inverted;
	int i = 0;
	int j = length;

	try {
		inverted = new int[length];

		while (i < length) {
			inverted[i] = source[j];
			i--;
			j++;
		}
	}
	catch (IndexOutOfBoundsException e) {
		System.out.println("Caught  Exception: " + e);
	}
	catch (Exception) {
		System.out.println("Caught  Exception ...");
	}

	inverted = new int[length];
	inverted = source;
	
	return inverted;
}