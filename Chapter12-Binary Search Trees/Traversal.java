/**
 * @author AJWuu
 */

package binarySearchTrees;

public class Traversal {

	public static <T> void preOrder(Node<T> root) {
		if (root != null) {
			System.out.print(root.key + " ");
			preOrder(root.left);
			preOrder(root.right);
		}
	}

	public static <T> void midOrder(Node<T> root) {
		if (root != null) {
			midOrder(root.left);
			System.out.print(root.key + " ");
			midOrder(root.right);
		}
	}

	public static <T> void postOrder(Node<T> root) {
		if (root != null) {
			postOrder(root.left);
			postOrder(root.right);
			System.out.print(root.key + " ");
		}
	}

}
