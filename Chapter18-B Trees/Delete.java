/**
 * @author AJWuu
 */

package bTrees;

public class Delete {

	public static int combine(BTNode x, BTNode left, BTNode right, int i) {
		int k; //the index of target key in new keys[]
		//combine left, x[i], right into left
		left.keys[left.n] = x.keys[i];
		k = left.n;
		left.n++;
		for (int j=0; j<right.n; j++) {
			left.keys[left.n+j+1] = right.keys[j];
			left.n++;
		}
		//delete right
		for (int j=i+1; j<x.children.length-1; j++) {
			x.children[j] = x.children[j+1];
		}
		//delete x[i]
		for (int j=i; j<x.n-1; j++) {
			x.keys[j] = x.keys[j+1];
		}
		return k;
	}

	public static void delete(BTree bt, int key) {
		BTNode x = Search.search(bt.getRoot(), key);
		if (x == null) {
			return ;
		}
		int i = 0;
		for (; i<x.n; i++) {
			if (x.keys[i] == key) {
				break;
			}
		}

		int T = bt.getT();
		if (x.isLeaf) { //leaf
			for (; i<x.n-1; i++) {
				x.keys[i] = x.keys[i+1];
			}
			x.keys[i] = 0;
			x.n--;
		}
		else { //non-leaf
			BTNode left = x.children[i];
			BTNode right = x.children[i+1];
			if (left.n >= T) {
				x.keys[i] = left.keys[left.n-1];
				left.keys[left.n-1] = 0;
			}
			else if (left.n < T && right.n >= T) {
				x.keys[i] = right.keys[0];
				for (int j=0; j<right.n-1; j++) {
					right.keys[j] = right.keys[j+1];
				}
			}
			else if (left.n < T && right.n < T) {
				int j = combine(x, left, right, i);
				for (; j<left.n-1; j++) {
					left.keys[j] = left.keys[j+1];
				}
				left.keys[j] = 0;
			}
		}
	}

}
