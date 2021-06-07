/**
 * @author AJWuu
 */

package intervalTree;

public class Delete {

	public static <T> void replace(IntervalTree<T> itt, ITNode<T> a, ITNode<T> b) {
		if (a.parent == null) {
			itt.setRoot(b);
		}
		else if (a == a.parent.left) {
			a.parent.left = b;
		}
		else {
			a.parent.right = b;
		}

		if (b != null) {
			b.parent = a.parent;
		}
	}

	public static <T extends Comparable<T>> void arrange(IntervalTree<T> itt, ITNode<T> x) {
		ITNode<T> w;
		while (x != itt.getRoot() && x.color == true) {
			if (x == x.parent.left) {
				w = x.parent.right;
				if (w.color == false) {
					w.color = true;
					x.parent.color = false;
					Rotation.leftRotation(itt, x.parent);
					w = x.parent.right;
				}
				if (w.left.color == true && w.right.color == true) {
					w.color = false;
					x = x.parent;
				}
				else {
					if (w.right.color == true) {
						w.left.color = true;
						w.color = false;
						Rotation.rightRotation(itt, w);
						w = x.parent.right;
					}
					w.color = x.parent.color;
					x.parent.color = true;
					w.right.color = true;
					Rotation.leftRotation(itt, x.parent);
					x = itt.getRoot();
				}
			}
			else {
				w = x.parent.left;
				if (w.color == false) {
					w.color = true;
					x.parent.color = false;
					Rotation.rightRotation(itt, x.parent);
					w = x.parent.left;
				}
				if (w.left.color == true && w.right.color == true) {
					w.color = false;
					x = x.parent;
				}
				else {
					if (w.left.color == true) {
						w.right.color = true;
						w.color = false;
						Rotation.leftRotation(itt, w);
						w = x.parent.left;
					}
					w.color = x.parent.color;
					x.parent.color = true;
					w.left.color = true;
					Rotation.rightRotation(itt, x.parent);
					x = itt.getRoot();
				}
			}
		}
		x.color = true;
	}

	public static <T extends Comparable<T>> void delete(IntervalTree<T> itt, interval<T> i) {
		ITNode<T> z = Search.searchExact(itt, i);
		if (z == null) {
			return ;
		}

		ITNode<T> y = z;
		ITNode<T> x = null;
		boolean COLOR = y.color;
		if (z.left == null && z.right == null) {
			if (z == z.parent.left) {
				z.parent.left = null;
			}
			else {
				z.parent.right = null;
			}
			x = z.parent;
			z = null;
		}
		else if (z.left == null && z.right != null) {
			x = z.right;
			replace(itt, z, x);
		}
		else if (z.left != null && z.right == null) {
			x = z.left;
			replace(itt, z, x);
		}
		else {
			y = Supplement.minimum(z.right);
			COLOR = y.color;
			x = y;
			if (y.parent == z) {
				x.parent = y;
			}
			else {
				replace(itt, y, y.right);
				y.right = z.right;
				y.right.parent = y;
			}
			replace(itt, z, y);
			y.left = z.left;
			y.left.parent = y;
			y.color = z.color;
		}

		if (COLOR == true) {
			arrange(itt, x);
		}
	}

}
