public class NoBreadException extends Exception {
	
	public NoBreadException(String topping) {
		super("There is no bread, only " + topping);
	}
	
}