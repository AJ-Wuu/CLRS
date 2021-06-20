/**
 * @author AJWuu
 */

package vEB;

public class Predecessor {

	public static int predecessor(vEB tree, int key) {
		if (tree.u == 2) {
			if (key == 1 && tree.min == 0) {
				return 0;
			}
			else {
				return -1;
			}
		}
		else if (tree.max != Integer.MIN_VALUE && key > tree.max) {
			return tree.max;
		}
		else {
			int minCluster = Compare.getMinimum(tree.cluster[tree.getHigh(key)]);
			int offset = 0;
			if (minCluster != -1 && tree.getLow(key) > minCluster) {
				offset = predecessor(tree.cluster[tree.getHigh(key)], tree.getLow(key));
				return tree.getIndex(tree.getHigh(key), offset);
			}
			else {
				int preCluster = predecessor(tree.summary, tree.getHigh(key));
				if (preCluster == -1) {
					if (tree.min != Integer.MAX_VALUE && key > tree.min) {
						return tree.min;
					}
					else {
						return -1;
					}
				}
				else {
					offset = Compare.getMaximum(tree.cluster[preCluster]);
					return tree.getIndex(preCluster, offset);
				}
			}
		}
	}
	
}
