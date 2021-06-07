/**
 * @author AJWuu
 */

package intervalTree;

public class Supplement {

	public static <T> ITNode<T> minimum(ITNode<T> root) {
		while (true) {
			if (root.left != null) {
				root = root.left;
			}
			else {
				return root;
			}
		}
	}

	public static <T> ITNode<T> maximum(ITNode<T> root) {
		while (true) {
			if (root.right != null) {
				root = root.right;
			}
			else {
				return root;
			}
		}
	}
	
	public static <T> void inOrder(ITNode<T> root) {
		if (root != null) {
			inOrder(root.left);
			System.out.print("[" + root.interval.low + "," + root.interval.high + ") ");
			inOrder(root.right);
		}
	}

	public static <T extends Comparable<T>> T getMax(ITNode<T> a, ITNode<T> a_left, ITNode<T> a_right) {
		T val, leftVal, rightVal;
		val = a.interval.high;
		int cmp;
		if (a_left != null && a_right != null) {
			leftVal = a_left.interval.high;
			rightVal = a_right.interval.high;
			cmp = val.compareTo(leftVal);
			if (cmp < 0) {
				cmp = leftVal.compareTo(rightVal);
				if (cmp < 0) {
					return rightVal;
				}
				else {
					return leftVal;
				}
			}
			else {
				cmp = val.compareTo(rightVal);
				if (cmp < 0) {
					return rightVal;
				}
				else {
					return val;
				}
			}
		}
		else if (a_left != null && a_right == null) {
			leftVal = a_left.interval.high;
			cmp = val.compareTo(leftVal);
			if (cmp < 0) {
				return leftVal;
			}
			else {
				return val;
			}
		}
		else if (a_left == null && a_right != null) {
			rightVal = a_right.interval.high;
			cmp = val.compareTo(rightVal);
			if (cmp < 0) {
				return rightVal;
			}
			else {
				return val;
			}
		}
		else {
			return val;
		}
	}

}
