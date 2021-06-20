/**
 * @author AJWuu
 */

package vEB;

public class Delete {

	public static void delete(vEB tree, int key) {
		if (tree.max == tree.min && tree.max == key) { //only one key in the tree
			tree.max = Integer.MIN_VALUE;
			tree.min = Integer.MAX_VALUE;
		}
		else if (tree.u == 2) {
			if (key == 0) {
				tree.min = 1;
			}
			else {
				tree.min = 0;
			}
			tree.max = tree.min;
		}
		else {
			if (key == tree.min) {
				//find the second-smallest key and set it to tree.min
				int tempMin = Compare.getMinimum(tree.summary);
				key = tree.getIndex(tempMin, Compare.getMinimum(tree.cluster[tempMin]));
				tree.min = key;
			}
			delete(tree.cluster[tree.getHigh(key)], tree.getLow(key));
			
			if (Compare.getMinimum(tree.cluster[tree.getHigh(key)]) == Integer.MAX_VALUE) {
				delete(tree.summary, tree.getHigh(key))
				if (key == tree.max) {
					int tempMax = Compare.getMaximum(tree.summary);
					if (tempMax == Integer.MIN_VALUE) { //only one key in the tree
						tree.max = tree.min;
					}
					else {
						tree.max = tree.getIndex(tempMax, Compare.getMaximum(tree.cluster[tempMax]));
					}
				}
			}
			else if (key == tree.max) {
				tree.max = tree.getIndex(tree.getHigh(key), Compare.getMaximum(tree.cluster[tree.getHigh(key)]));
			}
		}
	}
	
}
