/**
 * @author AJWuu
 */

package knapsack;

public class Knapsack {
	
	static int maxVal(int a, int b) {
		return (a > b) ? a : b;
	}
	
	static int sumVal(int[][] a, int row) {
		int sum = 0;
		for (int i : a[row]) {
			sum += i;
		}
		return sum;
	}

	static int knapsack(int[] value, int[] weight, int n, int W) {
		int[][] k = new int[n][W+1];
		for (int i=0; i<n; i++) {
			k[i][0] = 0;
		}
		for (int j=0; j<W+1; j++) {
			k[0][j] = 0;
		}
		for (int i=0; i<n-1; i++) {
			for (int j=0; j<W+1; j++) {
				if (j < weight[i]) {
					k[i+1][j] = k[i][j];
				}
				else {
					k[i+1][j] = maxVal(k[i][j], k[i][j] - weight[i] + value[i]);
				}
			}
		}
		int finalVal = 0;
		for (int m=0; m<n-1; m++) {
			if (sumVal(k, m) != sumVal(k, m+1)) {
				finalVal += value[m+1];
			}
		}
		return finalVal;
	}
	
	public static void main(String[] args) {
		int value[] = new int[] {60,100,120};
        int weight[] = new int[] {10,20,30};
        int W = 50;
        int n = value.length;
        System.out.println(knapsack(value, weight, n, W));
	}

}
