/**
 * @author AJWuu
 */

package redBlackTrees;

public class Insert {

	public static <T> void arrange(RBTree<T> rbt, Node<T> insertNode) {
		Node<T> tempNode;
		while (insertNode != rbt.getRoot() && !insertNode.parent.RB) {
			//insertNode is not root while insertNode.parent is also red, so insertNode is unbalanced
			//insertNode must have its grandparent; otherwise, it won't be unbalanced
			if (insertNode.parent == insertNode.parent.parent.left) { //all on the left branch
				tempNode = insertNode.parent.parent.right; //insertNode's uncle
				if (!tempNode.RB) {
					//Case A: uncle exists and is red -> re-color parent, uncle and grandparent
					insertNode.parent.RB = true;
					tempNode.RB = true;
					insertNode.parent.parent.RB = false;
					//move our sight upwards and try to solve above levels first
					insertNode = insertNode.parent.parent;
				}
				else {
					//Case B: uncle exists and is black -> triangle is formed and rotate
					if (insertNode == insertNode.parent.right) { //left-right case
						Rotation.leftRotation(rbt, insertNode.parent);
					}
					//Case C: line is formed -> re-color parent and grandparent, and rotate
					//left-left case
					insertNode = insertNode.left; //move the target Node to the bottom of the "line"
					insertNode.parent.RB = true;
					insertNode.parent.parent.RB = false;
					Rotation.rightRotation(rbt, insertNode.parent.parent);
				}
			}
			else { //all on the right branch
				tempNode = insertNode.parent.parent.left; //uncle
				if (!tempNode.RB) {
					//Case A
					tempNode.RB = true;
					insertNode.parent.RB = true;
					insertNode.parent.parent.RB = false;
					insertNode = insertNode.parent.parent;
				}
				else {
					//Case B
					if (insertNode == insertNode.parent.left) { //right-left case
						insertNode = insertNode.parent;
						Rotation.rightRotation(rbt, insertNode);
						//NOTE: it might have better efficiency than previous way because
						//      this has a core notion of changing/targeting everything needed before rotation
					}
					//Case C
					//right-right case
					insertNode.parent.RB = true;
					insertNode.parent.parent.RB = false;
					Rotation.leftRotation(rbt, insertNode.parent.parent);
				}
			}
		}
		rbt.setRootColor(true); //make sure the root is black
	}

	public static <T extends Comparable<T>> void insert(RBTree<T> rbt, T insertKey) {
		Node<T> insertNode = new Node<T>(false, insertKey, null, null, null);
		Node<T> tempNode = null;
		Node<T> root = rbt.getRoot();
		int cmp;

		if (root == null) { //the tree is empty
			insertNode.RB = true;
			rbt.setRoot(insertNode);
		}
		else { //the tree has nodes
			//First: find the place to insert
			while (root != null) {
				tempNode = root;
				cmp = insertKey.compareTo(root.key);
				if (cmp < 0) { //insertKey < root.key
					root = root.left;
				}
				else if (cmp > 0) {  //insertKey > root.key
					root = root.right;
				}
			}

			//Second: insert in the tree
			insertNode.parent = tempNode; //insert as the child of tempNode
			cmp = insertKey.compareTo(tempNode.key);
			if (cmp < 0) {
				tempNode.left = insertNode;
			}
			else if (cmp > 0) {
				tempNode.right = insertNode;
			}

			//Third: arrange the color of nodes
			arrange(rbt, insertNode);
		}
	}

}
