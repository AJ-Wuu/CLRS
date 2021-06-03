/**
 * @author AJWuu
 */

package binarySearchTrees;

public class InsertNode {

	public static <T extends Comparable<T>> void insert(BinarySearchTree<T> bst, T insertKey) {
		//parameter T is valid within the scope of this method (<T> return_type method_name())
		//when needs to compare (compareTo()), use <T extends Comparable<T>>; else, use <T>
		Node<T> root = bst.getRoot();
		Node<T> insertNode = new Node<T>(insertKey, null, null);
		if (root == null) { //no binary tree
			bst.setRoot(insertNode);
		}

		while (root != null) {
			int temp = insertNode.key.compareTo(root.key);
			if (temp < 0) { //insertNode < root
				if (root.left != null) {
					root = root.left;
				}
				else {
					root.left = insertNode;
					break;
				}
			}
			else if (temp > 0) { //insertNode > root
				if (root.right != null) {
					root = root.right;
				}
				else {
					root.right = insertNode;
					break;
				}
			}
		}
	}
	
}
