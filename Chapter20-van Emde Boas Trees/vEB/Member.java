/**
 * @author AJWuu
 */

package vEB;

public class Member {

	public static boolean isMember(vEB tree, int key) {
		if (tree.u < key) {
			return false;
		}
		if (tree.min == key || tree.max == key) {
			return true;
		}
		else {
			if (tree.u == 2) {
				//if u == 2, then the elements of the tree should be either tree.min or tree.max
				//since key is not equal to either of them (tested before), then key is not in the tree
				return false;
			}
			else {
				return isMember(tree.cluster[tree.getHigh(key)], tree.getLow(key));
			}
		}
	}
	
}
