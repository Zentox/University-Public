public class Y extends X {
	
	public Y(int n) {
		super(n);
	}

	@Override
	public void save(int n) {
		try {
			super.save(n);
		} catch (ArrayStoreException e) {
			int[] newA = new int[a.length * 2];
			boolean[] newWritable = new boolean[writable.length * 2];
			for (int i = 0; i < writable.length; i++) {
				newA[i] = a[i];
				newWritable[i] = writable[i];
			}
			for (int i = writable.length; i < newWritable.length; i++)
				newWritable[i] = true;
			a = newA;
			writable = newWritable;
			save(n);
		}
	}
	
}