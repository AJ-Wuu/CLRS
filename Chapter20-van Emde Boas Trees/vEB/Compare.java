/**
 * @author AJWuu
 */

package vEB;

public class Compare {

	public static int getMinimum(vEB tree) {
		return tree.min; //(tree.min == -1 ? -1 : tree.min)
	}
	
	public static int getMaximum(vEB tree) {
		return tree.max; //(tree.max == -1 ? -1 : tree.max)
	}
	
}
