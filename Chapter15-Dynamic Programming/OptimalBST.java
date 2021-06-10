/**
 * @author AJWuu
 */

package optimalBST;

public class OptimalBST {

	static int INF = Integer.MAX_VALUE;

	static int[][] optimalBST(double[] p, double[] q, int n) {
		double[][] e = new double[n+2][n+1];
		double[][] w = new double[n+2][n+1];
		int[][] root = new int[n+1][n+1];
		for (int i=1; i<=n+1; i++) {
			e[i][i-1] = q[i-1];
			w[i][i-1] = q[i-1];
		}
		int j;
		double t;
		for (int len=1; len<=n; len++) {
			for (int i=1; i<=n-len+1; i++) {
				j = i + len - 1;
				e[i][j] = INF;
				w[i][j] = w[i][j-1] + p[j] + q[j];
				for (int r=i; r<=j; r++) {
					t = e[i][r-1] + e[r+1][j] + w[i][j];
					if (t < e[i][j]) {
						e[i][j] = t;
						root[i][j] = r;
					}
				}
			}
		}
		return root;
	}

	static void constructOptimalBST(int[][] root, int i, int j, int r) {
		int rootChild = 0;
		if (i < root.length && j < root.length) {
			rootChild = root[i][j];
		}
		if (rootChild == root[1][root.length-1]) {
			System.out.println("k" + root[i][j] + " is the root");
			constructOptimalBST(root, i, rootChild-1, rootChild);
			constructOptimalBST(root, rootChild+1, j, rootChild);
			return ;
		}
		if (j < i-1) {
			return ;
		}
		else if (j == i-1) { //must be leaf
			if (j < r) {
				System.out.println("d" + j + " is the left child of k" + r);
			}
			else {
				System.out.println("d" + j + " is the right child of k" + r);
			}
			return ;
		}
		else {
			if (rootChild < r) { //must be non-leaf
				System.out.println("k" + rootChild + " is the left child of k" + r);
			}
			else {
				System.out.println("k" + rootChild + " is the right child of k" + r);
			}
		}
		constructOptimalBST(root, i, rootChild-1, rootChild);
		constructOptimalBST(root, rootChild+1, j, rootChild);
	}

	public static void main(String[] args) {
		double p[] = {-1,0.15,0.1,0.05,0.1,0.2};
		double q[] = {0.05,0.1,0.05,0.05,0.05,0.1};
		int n = p.length;
		int root[][] = optimalBST(p, q, n-1);
		constructOptimalBST(root, 1, n-1, -1);
	}

}
