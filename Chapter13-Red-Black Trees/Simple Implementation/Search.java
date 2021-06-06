/**
 * @author AJWuu
 */

package redBlackTrees;

public class Search {

	public static <T extends Comparable<T>> Node<T> search(RBTree<T> rbt, T searchKey) {
		Node<T> root = rbt.getRoot();
		int cmp;
		while (true) {
			cmp = searchKey.compareTo(root.key);
			if (cmp < 0) { //searchKey < root.key
				root = root.left;
				if (root == null) { //doesn't exist
					break;
				}
			}
			else if (cmp > 0) { //searchKey > root.key
				root = root.right;
				if (root == null) { //doesn't exist
					break;
				}
			}
			else { //searchKey == root.key
				return root;
			}
		}
		return null;
	}
	
}
