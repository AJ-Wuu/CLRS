/**
 * @author AJWuu
 */

package intervalTree;

public class Rotation {
	
	public static <T extends Comparable<T>> void leftRotation(IntervalTree<T> itt, ITNode<T> x) {
		ITNode<T> y = x.right;
		//child
		x.right = y.left;
		if (y.left != null) {
			y.left.parent = x;
		}
		//parent
		y.parent = x.parent;
		if (x.parent == null) {
			itt.setRoot(y);
		}
		else if (x == x.parent.left) {
			x.parent.left = y;
		}
		else {
			x.parent.right = y;
		}
		y.left = x;
		x.parent = y;
		//value
		y.max = x.max;
		x.max = Supplement.getMax(x, x.left, x.right);
	}
	
	public static <T extends Comparable<T>> void rightRotation(IntervalTree<T> itt, ITNode<T> x) {
		ITNode<T> y = x.left;
		//child
		x.left = y.right;
		if (y.right != null) {
			y.right.parent = x;
		}
		//parent
		y.parent = x.parent;
		if (x.parent == null) {
			itt.setRoot(y);
		}
		else if (x == x.parent.left) {
			x.parent.left = y;
		}
		else {
			x.parent.right = y;
		}
		y.right = x;
		x.parent = y;
		//value
		y.max = x.max;
		//x.max = Supplement.getMax(x.interval.high, x.left.interval.high, x.right.interval.high);
		//x.right never changes, so x.max shouldn't change
	}
	
}
