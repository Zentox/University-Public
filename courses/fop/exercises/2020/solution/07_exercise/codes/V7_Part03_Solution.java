public static int[] reverseArray(int[] source) throws Exception {
	int length = source.length;
	int[] inverted = null;
	int i = 0;
	int j = length - 1;

	try {
		inverted = new int[length];

		while (i < length) {
			inverted[i] = source[j];
			i++;
			j--;
		}
	}
	catch (IndexOutOfBoundsException e) {
		System.out.println("Caught  Exception: " + e);
	}
	catch (Exception e) {
		System.out.println("Caught  Exception ...");
	}
	
	return inverted;
}