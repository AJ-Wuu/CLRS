package redBlackTrees;

public class Supplement {

	public static <T> Node<T> minimum(Node<T> root) {
		while (true) {
			if (root.left != null) {
				root = root.left;
			}
			else {
				return root;
			}
		}
	}
	
	public static <T> void inOrder(Node<T> root) {
		if (root != null) {
			inOrder(root.left);
			System.out.print(root.key + " ");
			inOrder(root.right);
		}
	}
	
}
