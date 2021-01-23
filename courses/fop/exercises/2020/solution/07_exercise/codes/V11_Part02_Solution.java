@FunctionalInterface
public interface Lunch {
	
	String getTopping(String s) throws NoBreadException;
	
}