public static ArrayTuple split(double[] a) {
	List<Integer> even = new LinkedList<>();
	List<Double> odd = new LinkedList<>();
	for (double d : a) {
		if (d == (int) d) {
			even.add((int) d);
		} else {
			odd.add(d);
		}
	}
	int[] ev = new int[even.size()];
	double[] od = new double[odd.size()];
	for (int i = 0; i < ev.length; i++) {
		ev[i] = even.get(i);
	}
	for (int i = 0; i < od.length; i++) {
		od[i] = odd.get(i);
	}
	ArrayTuple tuple = new ArrayTuple();
	tuple.iArr = ev;
	tuple.dArr = od;
	return tuple;
}