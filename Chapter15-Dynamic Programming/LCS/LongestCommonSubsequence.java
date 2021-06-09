/**
 * @author AJWuu
 */

package longestCommonSubsequence;

public class LongestCommonSubsequence {

	static int maxVal(int a, int b) {
		if (a <= b) {
			return b;
		}
		else {
			return a;
		}
	}

	//Both b and c; O(m*n)
	static char[][] LCSbcmn(char[] X, char[] Y) {
		int m = X.length;
		int n = Y.length;
		char[][] b = new char[m][n];
		int[][] c = new int[m+1][n+1];
		for (int i=0; i<m+1; i++) {
			c[i][0] = 0;
		}
		for (int j=0; j<n+1; j++) {
			c[0][j] = 0;
		}

		for (int i=0; i<m; i++) {
			for (int j=0; j<n; j++) {
				if (X[i] == Y[j]) {
					c[i+1][j+1] = (c[i][j] + 1);
					b[i][j] = 'c'; //Combination -> upper left
				}
				else if (c[i][j+1] >= c[i+1][j]) {
					c[i+1][j+1] = c[i][j+1];
					b[i][j] = 'u'; //Up
				}
				else {
					c[i+1][j+1] = c[i+1][j];
					b[i][j] = 'l'; //left
				}
			}
		}
		return b;
	}

	//Memoized; Only c; O(m*n)
	static int[][] LCScmn(char[] X, char[] Y, int m, int n) {
		int[][] c = new int[m][n];
		for (int i=0; i<m; i++) {
			for (int j=0; j<n; j++) {
				c[i][j] = -1;
			}
		}
		LCScmnHelper(c, X, Y, m-1, n-1);
		return c;
	}

	static int LCScmnHelper(int[][] c, char[] X, char[] Y, int i, int j) {
		if (c[i][j] > -1) {
			return c[i][j];
		}
		if (i==0 || j==0) {
			c[i][j] = 0;
		}
		else {
			if (X[i] == Y[j]) {
				c[i][j] = LCScmnHelper(c, X, Y, i-1, j-1) + 1;
			}
			else {
				c[i][j] = maxVal(LCScmnHelper(c, X, Y, i-1, j), LCScmnHelper(c, X, Y, i, j-1));
			}
		}
		return c[i][j];
	}

	//Print with b; O(m+n);
	static void printLCSb(char[][] b, char[] X, int i, int j) {
		if (i==0 || j==0) { //length(s) == 0
			return ;
		}
		if (b[i-1][j-1] == 'c') {
			printLCSb(b, X, i-1, j-1);
			System.out.print(X[i-1] + " ");
		}
		else if (b[i-1][j-1] == 'u') {
			printLCSb(b, X, i-1, j);
		}
		else {
			printLCSb(b, X, i, j-1);
		}
	}

	//Print with c; O(m+n)
	//c1's priority up -> upper_left -> left gets: a b b a a b
	static void printLCSc1(int[][] c, char[] X, char[] Y, int i, int j) {
		if (c[i][j] == 0) {
			System.out.print(X[i] + " "); //this c doesn't have a group of 0 surroundings on left and top side
			return ;
		}
		if (X[i] == Y[j]) {
			printLCSc1(c, X, Y, i-1, j-1);
			System.out.print(X[i] + " ");
		}
		else if (c[i][j-1] > c[i-1][j]) {
			printLCSc1(c, X, Y, i, j-1);
		}
		else {
			printLCSc1(c, X, Y, i-1, j);
		}
	}

	//c2's priority left -> upper_left -> up gets: b a b a b a
	static void printLCSc2(int[][] c, char[] X, char[] Y, int i, int j) {
		if (c[i][j] == 0) {
			System.out.print(X[i] + " ");
			return ;
		}
		if (X[i] == Y[j]) {
			printLCSc2(c, X, Y, i-1, j-1);
			System.out.print(X[i] + " ");
		}
		else if (c[i-1][j] > c[i][j-1]) { //else if and else are the different places
			printLCSc2(c, X, Y, i-1, j);
		}
		else {
			printLCSc2(c, X, Y, i, j-1);
		}
	}

	//c3's priority upper_left -> up -> left gets a b a b a a
	static void printLCSc3(int[][] c, char[] X, char[] Y, int i, int j) {
		if (c[i][j] == 0) {
			if (i==0 || j==0) {
				System.out.print(X[i] + " ");
			}
			else {
				if (c[i-1][j-1] == 0) {
					printLCSc3(c, X, Y, i-1, j-1);
				}
				else if (c[i][j-1] == 0) {
					printLCSc3(c, X, Y, i, j-1);
				}
				else {
					printLCSc3(c, X, Y, i-1, j);
				}
			}
			return ;
		}
		if (X[i] == Y[j]) {
			printLCSc3(c, X, Y, i-1, j-1);
			System.out.print(X[i] + " ");
		}
		else if (c[i][j-1] >= c[i-1][j]) { //here is another difference
			printLCSc1(c, X, Y, i, j-1);
		}
		else {
			printLCSc1(c, X, Y, i-1, j);
		}
	}
	
	//There are multiple other possibilities for this set,
	//including bbaaba, ababab, abaaba, etc.

	public static void main(String[] args) {
		char[] X = new char[] {'a','b','b','a','b','a','b','a'};
		char[] Y = new char[] {'b','a','b','a','a','b','a','a','b'};
		printLCSb(LCSbcmn(X, Y), X, X.length, Y.length);
		System.out.println();
		printLCSc1(LCScmn(X, Y, X.length, Y.length), X, Y, X.length-1, Y.length-1);
		System.out.println();
		printLCSc2(LCScmn(X, Y, X.length, Y.length), X, Y, X.length-1, Y.length-1);
		System.out.println();
		printLCSc3(LCScmn(X, Y, X.length, Y.length), X, Y, X.length-1, Y.length-1);
	}

}
