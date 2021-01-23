public class MyException extends Exception {
	
	private String message;

	public MyException(String str, int n) {
		message = str + " " + n;
	}

	@Override
	public String getMessage() {
		return message;
	}
	
}