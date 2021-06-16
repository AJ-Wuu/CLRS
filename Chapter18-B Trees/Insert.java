/**
 * @author AJWuu
 */

package bTrees;

public class Insert {

	public static void split(BTNode x, int i) {
		BTNode y = x.children[i];
		int T = x.minDegree;
		BTNode z = new BTNode(T, y.isLeaf);

		z.n = T - 1;
		for (int j=0; j<T-1; j++) {
			z.keys[j] = y.keys[j+T];
		}
		if (!y.isLeaf) {
			for (int j=0; j<T; j++) {
				z.children[j] = y.children[j+T];
			}
		}

		y.n = T - 1;
		for (int j=x.n; j>=i+1; j--) {
			x.children[j+1] = x.children[j];
		}
		x.children[i+1] = z;
		for (int j=x.n-1; j>=i; j--) {
			x.keys[j+1] = x.keys[j];
		}
		x.keys[i] = y.keys[T-1];
		for (int j=y.keys.length-1; j>=T-1; j--) {
			y.keys[j] = 0;
		}
		x.n = x.n + 1;
	}

	public static void insertNode(BTNode x, int key) {
		int i = x.n - 1;
		if (x.isLeaf) {
			for ( ; i>=0 && key < x.keys[i]; i--) {
				x.keys[i+1] = x.keys[i]; //move all greater keys one place ahead
			}
			x.keys[i+1] = key;
			x.n++;
		}
		else {
			for ( ; i>=0 && key < x.keys[i]; i--) {
				;
			}
			//see if the found child is full
			BTNode temp = x.children[i+1];
			if (temp.n == 2 * x.minDegree - 1) { //full
				split(x, i+1);
				if (key > x.keys[i+1]) {
					i++;
				}
			}
			insertNode(x.children[i+1], key); //not full
		}
	}

	public static void insertKey(BTree bt, int key) {
		BTNode root = bt.getRoot();
		if (root == null) { //actually, this is never used (because bt has minDegree at the very beginning)
			root = new BTNode(bt.getT(), true);
			root.keys[0] = key;
			root.n = 1;
		}
		else {
			if (root.n == 2 * bt.getT() - 1) {
				BTNode s = new BTNode(bt.getT(), false);
				bt.setRoot(s);
				s.n = 0;
				s.children[0] = root;
				split(s, 0);
				insertNode(s, key);
			}
			else {
				insertNode(root, key);
			}
		}
	}

}
