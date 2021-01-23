@Test
public void testNoSorting() {
	int[] a = { 1, 5, 3, 10, 6, 2, 3, 4, 5, 7, 6, 7, 8, 9, 2 };
	int[] expected = { 1, 5, 3, 10, 6, 2, 3, 4, 5, 7, 6, 7, 8, 9, 2 };
	try {
		assertArrayEquals(expected, betweenNumbers(a, 0, 20));
	} catch (LowerBiggerThanUpperException e) {
		fail();
	}
}

@Test
public void testSorting() {
	int[] a = { 1, 5, 3, 10, 6, 3, 4, 2, 5, 7, 6, 7, 8, 9, 2 };
	int[] expected = { 1, 5, 3, 6, 10, 3, 4, 2, 5, 6, 7, 7, 8, 9, 2 };
	try {
		assertArrayEquals(expected, betweenNumbers(a, 0, 4));
	} catch (LowerBiggerThanUpperException e) {
		fail();
	}
}

@Test
public void testException() {
	int[] a = { 1, 5, 3, 10, 6, 2, 3, 4, 5, 7, 6, 7, 8, 9, 2 };
	assertThrows(LowerBiggerThanUpperException.class,
		() -> betweenNumbers(a, 4, 3));
}