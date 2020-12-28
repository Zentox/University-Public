public class YZ extends XY implements B {

	public YZ(long r) {
		super(r);
	}

	public double m1(int n, char c) {
		return n + c + p;
	}

	public String m2() {
		return "Hallo";
	}

	public void m3(XY xy) {
		p += xy.p;
	}
}