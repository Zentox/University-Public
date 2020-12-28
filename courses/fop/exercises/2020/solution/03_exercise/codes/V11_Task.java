public final class A {
	private int value1 = 0, value2 = 0;
	private final int value3 = 0;

	private int getValue1() {
		return value1;
	}

	private int getValue2() {
		return value2;
	}

	private void setValue1(int newValue1) {
		value1 = newValue1;
	}

	private void setValue2(int newValue2) {
		value2 = newValue2;
	}

	private final void changeValue3(final int newValue3) {
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
			getValue1() + "." +
			getValue2() + "." +
			obj.value3 +
			" kommt es zu einem Ueberlauf des Unix Zeitstempels.";

		System.out.println(result);
	}
}