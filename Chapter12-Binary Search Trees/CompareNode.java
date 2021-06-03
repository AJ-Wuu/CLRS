/**
 * @author AJWuu
 */

package binarySearchTrees;

public class CompareNode {

	public static <T> T minKey(Node<T> root) {
		if (root == null) {
			return null;
		}
		
		while (root.left != null) {
			root = root.left;
		}
		return root.key;
	}

	public static <T> T maxKey(Node<T> root) {
		if (root == null) {
			return null;
		}
		
		while (root.right != null) {
			root = root.right;
		}
		return root.key;
	}

}
