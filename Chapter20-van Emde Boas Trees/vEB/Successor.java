/**
 * @author AJWuu
 */

package vEB;

public class Successor {

	public static int successor(vEB tree, int key) {
		if (tree.u == 2) {
			if (key == 0 && tree.max == 1) {
				return 1;
			}
			else {
				return -1;
			}
		}
		else if (tree.min != Integer.MAX_VALUE && key < tree.min) {
			return tree.min;
		}
		else {
			int maxCluster = Compare.getMaximum(tree.cluster[tree.getHigh(key)]);
			int offset = 0;
			if (maxCluster != Integer.MIN_VALUE && tree.getLow(key) < maxCluster) {
				offset = successor(tree.cluster[tree.getHigh(key)], tree.getLow(key));
				return tree.getIndex(tree.getHigh(key), offset);
			}
			else {
				int sucCluster = successor(tree.summary, tree.getHigh(key));
				if (sucCluster == -1) {
					return -1;
				}
				else {
					offset = Compare.getMinimum(tree.cluster[sucCluster]);
					return tree.getIndex(sucCluster, offset);
				}
			}
		}
	}
	
}
