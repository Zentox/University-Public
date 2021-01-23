public static void main(String[] args) {
	int[] arr = new int[10];
	try {
		System.out.println(arr[77]);
	} catch (ArrayIndexOutOfBoundsException e) {
		System.out.print(e.getMessage());
	}
}