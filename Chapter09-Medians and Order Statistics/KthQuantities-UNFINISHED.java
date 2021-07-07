/**
 * @author AJWuu
 */

package kthQuantities;

import kthQuantiles.KthQuantiles;

public class KthQuantities {

	public void k_QUANTITIES_SUB(int[] A, int p, int r, int pos[], int f, int e, int quantiles[]) {
        if (f + 1 > e) return;
        int mid = (f + e) / 2;
        int q = KthQuantiles.RANDOMIZED_SELECT(A, p, r, pos[mid]);
        int val = q;
        quantiles[mid] = val;
        int k = q - p + 1;
        for (int i = mid; i < e; i++) {
            pos[i] = pos[i] - k;
        }
        k_QUANTITIES_SUB(A, q + 1, r, pos, mid + 1, e, quantiles);
    }

    public int[] k_QUANTITIES(int[] A, int k) {
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
        for (int i :
                quantiles) {
            System.out.println(i);
        }
        return quantiles;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
