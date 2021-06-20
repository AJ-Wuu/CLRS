/**
 * @author AJWuu
 */

package vEB;

public class Insert {
	
	public static void insert(vEB tree, int key) {
		if (tree.max == Integer.MIN_VALUE && tree.min == Integer.MAX_VALUE) { //no key in the tree
			tree.max = key;
			tree.min = key;
		}
		else {
			if (key < tree.min) {
				int temp = tree.min;
				tree.min = key;
				key = temp;
				//tree.min is the minimum of one of the internal cluster,
				//so we need to use this minimum to get to its real position in the tree
				//similar to "Lazy Propagation"
			}
			
			//no base case
			if (tree.u > 2) {
				if (Compare.getMinimum(tree.cluster[tree.getHigh(key)]) == Integer.MAX_VALUE) { //no key in the cluster
					insert(tree.summary, tree.getHigh(key));
					tree.cluster[tree.getHigh(key)].min = tree.getLow(key);
					tree.cluster[tree.getHigh(key)].max = tree.getLow(key);
				}
				else {
					insert(tree.cluster[tree.getHigh(key)], tree.getLow(key));
				}
			}
			
			if (key > tree.max) {
				tree.max = key;
			}
		}
	}

}
