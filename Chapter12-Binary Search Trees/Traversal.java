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

	public static <T> void inOrder(Node<T> root) {
		if (root != null) {
			inOrder(root.left);
			System.out.print(root.key + " ");
			inOrder(root.right);
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
