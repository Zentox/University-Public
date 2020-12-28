public class A {
	private int value1 = 0, value2 = 0;
	public int value3 = 0;

	public int getValue1() {
		return value1;
	}

	public int getValue2() {
		return value2;
	}

	public void setValue1(int newValue1) {
		value1 = newValue1;
	}

	public void setValue2(int newValue2) {
		value2 = newValue2;
	}

	public void changeValue3(final int newValue3) {
		value3 = 0;
	}
}

class B extends A {
	public void changeValue3(final int newValue3) {
		value3 = newValue3;
	}

	public static void main(String args[]) {
		B obj = new B();
		obj.setValue1(19);
		obj.setValue2(1);
		obj.value3 = 2038;
		
		String result = "Am " +
			obj.getValue1() + "." +
			obj.getValue2() + "." +
			obj.value3 +
			" kommt es zu einem Ueberlauf des Unix Zeitstempels.";

		System.out.println(result);
	}
}