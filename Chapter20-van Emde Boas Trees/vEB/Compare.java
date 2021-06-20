/**
 * @author AJWuu
 */

package vEB;

public class Compare {

	public static int getMinimum(vEB tree) {
		return tree.min; //(tree.min == Integer.MAX_VALUE ? -1 : tree.min)
	}
	
	public static int getMaximum(vEB tree) {
		return tree.max; //(tree.max == Integer.MIN_VALUE ? -1 : tree.max)
	}
	
}
