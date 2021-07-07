/**
 * @author AJWuu
 */

package kthQuantiles;

public class KthQuantiles {

	private static int RANDOMIZED_PARTITION(int[] A, int p, int r) {
		int i = (int) (Math.random() * (r - p) + p + 1);
		int temp = A[i];
		A[i] = A[r];
		A[r] = temp;
		return PARTITION(A, p, r);
	}

	private static int PARTITION(int[] A, int p, int r) {
		int curr = A[r];
		int i = p;
		int t = 0;
		for (int j = p; j < r; j++) {
			if (A[j] <= curr) {
				A[r] = A[i];
				A[i] = A[j];
				A[j] = A[r];
				i++;
			}
		}
		A[r] = A[i];
		A[i] = curr;
		return i;
	}

	public static int RANDOMIZED_SELECT(int A[], int p, int r, int i) {
		while (p!=r) {
			int q = RANDOMIZED_PARTITION(A, p, r);
			if (i-1==q) return A[q];
			else if (i-1<q) return RANDOMIZED_SELECT(A, p, q - 1, i);
			else return RANDOMIZED_SELECT(A, q+1, r, i);
		}
		return A[p];
	}

	public static void k_QUANTITIES_SUB(int[] A, int p, int r, int pos[], int f, int e, int quantiles[]) {
		if (f + 1 > e) return;
		int mid = (f + e) / 2;
		int q = RANDOMIZED_SELECT(A, p, r, pos[mid]);
		int val = q;
		quantiles[mid] = val;
		int k = q - p + 1;
		for (int i = mid; i < e; i++) {
			pos[i] = pos[i] - k;
		}
		k_QUANTITIES_SUB(A, q + 1, r, pos, mid + 1, e, quantiles);
	}

	public static int[] k_QUANTITIES(int[] A, int k) {
		int num = A.length / k;
		int mod = A.length % k;
		int []pos = new int[k];
		for (int i = 0; i < mod; i++) {
			pos[i] = pos[i] + 1;
		}
		for (int i = 1; i < k; i++) {
			pos[i] = pos[i] + pos[i - 1];
		}
		int[] quantiles = new int[k];
		k_QUANTITIES_SUB(A, 0, A.length, pos, 0, pos.length, quantiles);
		for (int i : quantiles) {
			System.out.println(i);
		}
		return quantiles;
	}

	public static void main(String[] args) {
		int[] array = {9, 5, 2, 4, 31, 16, 7, 4, 12, 8, 1, 6, 5, 3, 4, 7, 7, 4};
		k_QUANTITIES(array, 4);
	}

}
