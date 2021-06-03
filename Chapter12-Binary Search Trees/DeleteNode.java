/**
 * @author AJWuu
 */

package binarySearchTrees;

public class DeleteNode {

	public static <T extends Comparable<T>> void delete(BinarySearchTree<T> bst, T deleteKey) {
		Node<T> root = bst.getRoot();
		Node<T> upperNode = root;
		int LeftOrRight = 0; //0 for left, 1 for right
		while (root != null) {
			int temp = deleteKey.compareTo(root.key);
			if (temp < 0) { //deleteNode < root
				upperNode = root;
				root = root.left;
				LeftOrRight = 0;
			}
			else if (temp > 0) { //deleteNode > root
				upperNode = root;
				root = root.right;
				LeftOrRight = 1;
			}
			else { //deleteNode == root
				//start deleting
				if (root.left==null & root.right==null) { //leaf itself
					if (LeftOrRight == 0) {
						upperNode.left = null;
					}
					else {
						upperNode.right = null;
					}
					break;
				}
				else if (root.left!=null & root.right==null) { //only with left branch
					if (LeftOrRight == 0) {
						upperNode.left = root.left;
					}
					else {
						upperNode.right = root.left;
					}
					break;
				}
				else if (root.left==null & root.right!=null) { //only with right branch
					if (LeftOrRight == 0) {
						upperNode.left = root.right;
					}
					else {
						upperNode.right = root.right;
					}
					break;
				}
				else { //with both branches
					if (LeftOrRight == 0) {
						//the upper.left.left.max is the new key at upper.left (upper.left == root)
						if (root.left != null) {
							root = root.left;
						}
						while (root.right!=null && root.right.right!=null) {
							root = root.right;
						}
						if (root.left != null) {
							root.right = upperNode.left.right;
							upperNode.left = root;
						}
						else {
							upperNode.left.key = root.right.key;
							root.right = null;
						}
					}
					else {
						//the upper.right.right.min is the new key at upper.right (upper.right == root)
						if (root.right != null) {
							root = root.right;
						}
						while (root.left!=null && root.left.left!=null) {
							root = root.left;
						}
						if (root.right != null) {
							root.left = upperNode.right.left;
							upperNode.right = root;
						}
						else {
							upperNode.right.key = root.left.key;
							root.left = null;
						}
					}
				}
				break;				
			}
		}
	}

}
