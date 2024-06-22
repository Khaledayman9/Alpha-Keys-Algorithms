package alpha;

public class giga_chads{

	public static void main(String[] args) {
		int[] arr = { 1, 3, 4, 2 };
		System.out.println(alpha(arr));
	}

	// main function
	public static int alpha(int[] keys) {
		int[] x = new int[2];
		return finalHelper(keys, 0, 0, x, 0, 0);
	}

	// getting the final boundaries of the sub-array that will be reversed then
	// finding the sum
	public static int finalHelper(int[] keys, int beginNum, int optimalBegin, int[] x, int maxCurr, int maxHigh) {
		int[] result = alphaHelper(keys, beginNum, optimalBegin, x, maxCurr, maxHigh);
		int low = result[0];
		int high = result[1];
		int[] finalResult = new int[keys.length];
		for (int i = 0; i < keys.length; i++) {
			finalResult[i] = keys[i];
		}
		finalResult = reverse(finalResult, low, high);
		int sum = 0;
		for (int i = 0; i < finalResult.length; i += 2) {
			sum += finalResult[i];
		}
		return sum;
	}

	// To reverse an array given the start "i" and end "j"
	public static int[] reverse(int[] x, int i, int j) {
		if (i < j) {// Swap
			int tmp = x[i];
			x[i] = x[j];
			x[j] = tmp;
			reverse(x, ++i, --j);// Recursive
		}
		return x;
	}

	// Used to find the beginning and end of the sub-array to be swapped
	public static int[] alphaHelper(int[] keys, int beginNum, int optimalBegin, int[] x, int maxCurr, int maxHigh) {
		if (beginNum == keys.length) {
			int[] y = { optimalBegin, maxHigh };
			return y;
		}
		if (beginNum % 2 == 0) {
			x = alphaHelperEven(keys, 0, beginNum, beginNum + 1, 0, 0);
			if (x[1] > maxCurr) {
				maxCurr = x[1];
				maxHigh = x[0];
				optimalBegin = beginNum;
			}
			return alphaHelper(keys, beginNum + 1, optimalBegin, x, maxCurr, maxHigh);
		} else {
			x = alphaHelperOdd(keys, 0, beginNum, beginNum + 1, 0, 0);
			if (x[1] > maxCurr) {
				maxCurr = x[1];
				maxHigh = x[0];
				optimalBegin = beginNum;
			}
			return alphaHelper(keys, beginNum + 1, optimalBegin, x, maxCurr, maxHigh);
		}
	}

	// Used when the beginning is an even number, , to find the end of the sub-array
	// to be reversed
	public static int[] alphaHelperEven(int[] keys, int curr, int low, int high, int maxCurr, int maxHigh) {
		if (high >= keys.length) {
			int[] x = { maxHigh, maxCurr };
			return x;
		}
		curr += keys[high] - keys[low];
		if (curr >= maxCurr) {
			maxHigh = high;
			maxCurr = curr;
		}
		return alphaHelperEven(keys, curr, low + 2, high + 2, maxCurr, maxHigh);
	}

	// Used when the beginning is an odd number, to find the end of the sub-array to
	// be reversed
	public static int[] alphaHelperOdd(int[] keys, int curr, int low, int high, int maxCurr, int maxHigh) {
		if (high >= keys.length) {
			int[] x = { maxHigh, maxCurr };
			return x;
		}
		curr += keys[low] - keys[high];
		if (curr > maxCurr) {
			maxHigh = high;
			maxCurr = curr;
		}
		return alphaHelperOdd(keys, curr, low + 2, high + 2, maxCurr, maxHigh);
	}

}
