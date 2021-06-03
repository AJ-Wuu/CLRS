/**
 * @author AJWuu
 */

package binarySearchTrees;

public class SearchNode {

	public static <T extends Comparable<T>> boolean search(BinarySearchTree<T> bst, T targetKey) {
		Node<T> root = bst.getRoot();
		while (root != null) {
			int temp = targetKey.compareTo(root.key);
			if (temp < 0) { //targetNode < root
				root = root.left;
			}
			else if (temp > 0) { //targetNode > root
				root = root.right;
			}
			else { //targetNode == root
				return true;
			}
		}
		return false;
	}

}
