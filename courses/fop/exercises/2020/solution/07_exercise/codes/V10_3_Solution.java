public class Y extends X {

	public int m(int n) {
		try {
			return km(n);
		} catch (MyException e) {
			System.out.println(e.getMessage());
		}
		return 0;
	}
	
}