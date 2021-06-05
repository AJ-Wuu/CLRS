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
	
	public static <T> void midOrder(Node<T> root) {
		if (root != null) {
			midOrder(root.left);
			System.out.print(root.key + " ");
			midOrder(root.right);
		}
	}
	
}
