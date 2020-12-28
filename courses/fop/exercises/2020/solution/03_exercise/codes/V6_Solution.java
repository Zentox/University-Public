	/**
	 * Returns the longest sub sequence that exists forwards and backwards in the
	 * given array. If there is none, return 0.
	 * 
	 * @param arr array to find the longest sub sequence
	 * @return the longest sub sequence
	 */
	int maxMirror(int[] arr) {
		int max = 0;
		int current;
		for (int i = 0; i < arr.length; i++) {
			for (int j = arr.length - 1; j > i; j--) {
				int left = i;
				int right = j;
				current = 0;
				// Computes sub sequence length
				while (left < right && arr[left] == arr[right]) {
					current++;
					left++;
					right--;
				}
				// Check if it is the longest subsequence
				if (max < current) {
					max = current;
				}
			}
		}
		return max;
	}