/**
 * @author AJWuu
 */

package intervalTree;

public class Insert {

	public static <T extends Comparable<T>> void arrange(IntervalTree<T> itt, ITNode<T> z) {
		ITNode<T> y;
		while (z != itt.getRoot() && z.parent.color == false) {
			if (z.parent == z.parent.parent.left) {
				y = z.parent.parent.right; //uncle
				if (y != null && y.color == false) {
					z.parent.color = true;
					y.color = true;
					z.parent.parent.color = false;
					z = z.parent.parent;
				}
				else {
					if (z == z.parent.right) {
						z = z.parent;
						Rotation.leftRotation(itt, z);
					}
					z.parent.color = true;
					z.parent.parent.color = false;
					Rotation.rightRotation(itt, z.parent.parent);
				}
			}
			else {
				y = z.parent.parent.left;
				if (y != null && y.color == false) {
					z.parent.color = true;
					y.color = true;
					z.parent.parent.color = false;
					z = z.parent.parent;
				}
				else {
					if (z == z.parent.left) {
						z = z.parent;
						Rotation.rightRotation(itt, z);
					}
					z.parent.color = true;
					z.parent.parent.color = false;
					Rotation.leftRotation(itt, z.parent.parent);
				}
			}
		}
		itt.getRoot().color = true;
	}

	public static <T extends Comparable<T>> void insert(IntervalTree<T> itt, interval<T> z_interval) {
		ITNode<T> z = new ITNode<T>(false, z_interval, z_interval.high, null, null, null);
		ITNode<T> y = null;
		ITNode<T> x = itt.getRoot();
		int cmp;
		if (x == null) {
			z.color = true;
			itt.setRoot(z);
			return ;
		}

		while (x != null) {
			y = x;
			cmp = z.interval.low.compareTo(x.interval.low); //use low as the KEY
			if (cmp < 0) {
				x = x.left;
			}
			else {
				x = x.right;
			}
		}
		z.parent = y;
		cmp = z.interval.low.compareTo(y.interval.low);
		if (cmp < 0) {
			y.left = z;
		}
		else {
			y.right = z;
		}
		arrange(itt, z);
	}

}
