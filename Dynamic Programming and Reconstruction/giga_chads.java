public class giga_chads {

	public static void main(String[] args) {
		// FOR TESTING
		int keys[] = { 1, 3, 4, 2 };
		// alpha results:
		System.out.println("Maximum sum = " + alpha(keys));
		// alphaRec results:
		int[] indices = alphaRec(keys);
		System.out.println("low: " + indices[0]);
		System.out.println("high: " + indices[1]);
	}

// Assignment 2 Method:
	public static int alpha(int[] keys) {
		int normalSum = 0;
		int result = 0;
		int maxSum = 0;
		int currentSum = 0;
		int n1 = 0;
		int n2 = 0;
		for (int i = 0; i < keys.length; i++) {
			if (i % 2 == 0) {
				normalSum += keys[i];
			}
		}
		if (keys.length % 2 == 0) {
			n1 = keys.length - keys.length % 2;
			n2 = (keys.length - keys.length % 2) - 1;
		} else {
			n1 = keys.length - keys.length % 2;
			n2 = keys.length - keys.length % 2;
		}
		for (int i = 0; i < n1; i += 2) {
			currentSum = Math.max(0, currentSum + keys[i + 1] - keys[i]);
			maxSum = Math.max(currentSum, maxSum);
		}
		currentSum = 0;
		for (int i = 1; i < n2; i += 2) {
			currentSum = Math.max(0, currentSum + keys[i] - keys[i + 1]);
			maxSum = Math.max(currentSum, maxSum);
		}
		result = maxSum + normalSum;
		return result;
	};

// Assignment 3 Method/Methods:

	public static int[] alphaRec(int[] keys) {
		int[] x = new int[2];
		return finalHelper(keys, 0, 0, x, 0, 0);
	}

	public static int[] finalHelper(int[] keys, int beginNum, int optimalBegin, int[] x, int maxCurr, int maxHigh) {
		int[] result = alphaHelper(keys, beginNum, optimalBegin, x, maxCurr, maxHigh);
		int low = result[0];
		int high = result[1];
		int[] finalResult = new int[keys.length];
		for (int i = 0; i < keys.length; i++) {
			finalResult[i] = keys[i];
		}

		int[] resultArray = new int[2];

		if (low == 0 && high == 0) {
			resultArray[0] = -1;
			resultArray[1] = -1;
		} else {
			resultArray[0] = low;
			resultArray[1] = high;
		}
		return resultArray;
	}

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
