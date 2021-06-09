/**
 * @author AJWuu
 */

package longestIncreasingSubsequence;

import java.util.Arrays;

public class LongestCommonIncreasingSubsequence {

	static int[][] memoLCIS(int[] X, int[] Y) {
		char[][] b = new char[X.length][Y.length]; //it's more like a signal than a functional array
		int[][] c = new int[X.length][Y.length];
		memoLCISAux(X, Y, b, c);
		return c;
	}

	//O(n^2)
	static int memoLCISAux(int[] X, int[] Y, char[][] b, int[][] c) {
		int m = X.length;
		int n = Y.length;
		if (c[m-1][n-1] != 0 || m==1 || n==1) {
			return c[m-1][n-1];
		}
		if (X[m-1] == Y[n-1]) {
			b[m-1][n-1] = 'c'; //upper left
			//Arrays.copyOfRange(array, lower_bound, upper_bound)
			// -> new array includes lower_bound element, but doesn't include upper_bound element
			c[m-1][n-1] = memoLCISAux(Arrays.copyOfRange(X, 0, m-1), Arrays.copyOfRange(Y, 0, n-1), b, c) + 1;
		}
		else if (memoLCISAux(Arrays.copyOfRange(X, 0, m-1), Y, b, c) >= memoLCISAux(X, Arrays.copyOfRange(Y, 0, n-1), b, c)) {
			b[m-1][n-1] = 'u'; //up
			c[m-1][n-1] = memoLCISAux(Arrays.copyOfRange(X, 0, m-1), Y, b, c);
		}
		else {
			b[m-1][n-1] = 'l'; //left
			c[m-1][n-1] = memoLCISAux(X, Arrays.copyOfRange(Y, 0, n-1), b, c);
		}
		return c[m-1][n-1];
	}

	static void printLCIS(int[][] c, int[] X, int[] Y) {
		int i = X.length - 1;
		int j = Y.length - 1;
		int n = c[i][j] + 1;
		int[] s = new int[n];
		while (i>=0 && j>=0) { //s[] has at least 2 elements
			if (X[i] == Y[j]) {
				s[n-1] = X[i];
				n = n - 1;
				i = i - 1;
				j = j - 1;
			}
			else if (c[i-1][j] >= c[i][j-1]) {
				i = i - 1;
			}
			else {
				j = j - 1;
			}
		}
		for (int k=0; k<s.length; k++) {
			System.out.print(s[k] + " ");
		}
	}

	public static void main(String[] args) {
		int X[] = {1,2,3,2,12,17,21,31,35};
		int Y[] = {1,2,1,6,7,12,13,21,41};
		printLCIS(memoLCIS(X, Y), X, Y);
	}

}
