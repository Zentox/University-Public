public interface I1 {

	void m1();

}

public interface I2 extends I1 {

	void m2(int i);

}

public class C1 implements I2 {

	int number;

	@Override
	public void m1() {
		number = -1;
	}

	@Override
	public void m2(int i) {
		number = i;
	}

}