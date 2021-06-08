package matrixChainMultiplication;

import java.util.Arrays;

public class MatrixChainMultiplication {
	
	static int INF = Integer.MAX_VALUE;
	static int[][] mem = new int[100][100];

	static int minVal(int a, int b) {
		if (a <= b) {
			return a;
		}
		else {
			return b;
		}
	}
	
	//Recursion
	static int matrixChainRecursion(int[] num, int i, int j) {
		if (i == j) {
			return 0;
		}
		
		int minRound = INF;
		for (int k=i; k<j; k++) {
			minRound = minVal(minRound, matrixChainRecursion(num, i, k) + matrixChainRecursion(num, k+1, j) + num[i-1]*num[k]*num[j]);
		}
		return minRound;
	}
	
	static int matrixChainMemoization(int[] num, int i, int j) {
		if (i == j) {
			return 0;
		}
		
		//Because mem[][]'s size is set, this method is not the best choice
		if (mem[i][j] != -1) {
			return mem[i][j];
		}
		mem[i][j] = INF;
		for (int k=i; k<j; k++) {
			mem[i][j] = minVal(mem[i][j], matrixChainMemoization(num, i, k) + matrixChainMemoization(num, k+1, j) + num[i-1]*num[k]*num[j]);
		}
		return mem[i][j];
	}
	
	//Tabulation
	static int matrixChainOrder(int[] num) {
		int n = num.length;
		int[][] m = new int[n][n];
		
		for (int i=0; i<n; i++) {
			m[i][i] = 0;
		}
		int j, minRound;
		for (int L=2; L<n; L++) { //L is the chain length
			for (int i=1; i<n-L+1; i++) {
				j = i + L - 1;
				if (j == n) {
					continue;
				}
				m[i][j] = INF;
				for (int k=i; k<=j-1; k++) {
					minRound = m[i][k] + m[k+1][j] + num[i-1]*num[k]*num[j];
					if (minRound < m[i][j]) {
						m[i][j] = minRound;
					}
				}
			}
		}
		return m[1][n-1];
	}
	
	public static void main(String[] args) {
		int num[] = new int[]{5,10,3,12,5,50,6};
		for (int[] row : mem) {
		      Arrays.fill(row, -1); //one way to fill in all places of a matrix
		}
		System.out.println("Minimum number of calculation process is " + 
							"Recursion: " + matrixChainRecursion(num, 1, num.length-1) +
							"; Memoization: " + matrixChainMemoization(num, 1, num.length-1) +
							"; Tabulation: " + matrixChainOrder(num));
	}

}
