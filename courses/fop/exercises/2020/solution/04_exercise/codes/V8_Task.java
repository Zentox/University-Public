public class Alpha {
	protected int v;
	
	public Alpha(int a) {
		v = a;
	}
}

public class Beta extends Alpha {
	public Beta(int b, int c) {
		super(b);
		v = c;
	}

	public Alpha x1() {
		super.v++;
		return new Beta(0, v);
	}

	public int x2(int x) {
		return x + ++v + v++;
	}
}
		
public class Gamma extends Beta {
	private short y;
	
	public Gamma(int d, int e) {
		super(d, e);
		y = (short) d;
	}

	public int x2(int x) {
		return x - y;
	}

public static void main(String[] args) {
	Alpha a = new Alpha(7);
	Beta b = new Beta(0, 1);
	Gamma g = new Gamma(9, 2);
	a = b.x1();
	int t = b.x2(5);
	a = new Beta(10, 12).x1();
	b = g;
	int r = g.x2(50);
	}
}