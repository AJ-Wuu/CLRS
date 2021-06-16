/**
 * @author AJWuu
 */

package bTrees;

public class Search {
	
	public static BTNode search(BTNode x, int k) {
		int i = 0;
		while (i < x.n && k > x.keys[i]) {
			i++;
		}
		if (i <= x.n && k == x.keys[i]) {
			return x;
		}
		else if (x.isLeaf) { //no children
			return null;
		}
		else {
			return search(x.children[i], k);
		}
	}
	
}
