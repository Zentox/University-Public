public class B1 {
	public float f;
	private boolean b;
	protected byte by;

	int m1() {
		return -1;
	}

	private int m2() {
		return -2;
	}
}

public class B2 extends B1 {
	int i;
	public double d;

	protected int m2() {
		return 2;
	}

	public static void main(String[] args) {
		B2 obj = new B2();
	}
}