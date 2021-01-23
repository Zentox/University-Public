public class X {
	
	public static int km(int n) throws MyException {
		if (n < 0) {
			throw new MyException("n can not be negative", n);
		}
		return n * n;
	}
	
}