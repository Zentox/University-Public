public void test() {
	String test = "no";
	try {
		doRisky(test);
	} catch (ExplodeException ex) {
		System.out.println("catching  ExplodeException!");
	}
}

public void doRisky(String test) throws ExplodeException {
	System.out.println("begin  doRisky");
	if (test.equals("yes")) {
		throw new ExplodeException();
	}
	System.out.println("end  doRisky");
	return;
}