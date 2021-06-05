/**
 * @author AJWuu
 */

package redBlackTrees;

public class Delete {

	public static <T> void replace(RBTree<T> rbt, Node<T> a, Node<T> b) {
		//replace a with b
		if (a.parent == null) { // a is the root
			rbt.setRoot(b);
		}
		else if (a == a.parent.left) { // a is the left sub-tree
			a.parent.left = b;
		}
		else { // a is the right sub-tree
			a.parent.right = b;
		}
		b.parent = a.parent;
	}

	public static <T> void arrange(RBTree<T> rbt, Node<T> targetNode) {
		while (targetNode != rbt.getRoot() && targetNode.RB) { //targetNode is not the root and is black
			Node<T> relevantNode = null;
			if (targetNode == targetNode.parent.left) { //all on the left branch
				relevantNode = targetNode.parent.right;
				if (!relevantNode.RB) {
					//Case D: sibling is red -> swap colors between parent and sibling, and rotate
					relevantNode.RB = true;
					targetNode.parent.RB = false;
					Rotation.leftRotation(rbt, targetNode.parent);
					relevantNode = targetNode.parent.right; //update the sibling, which is always black now
				}
				//Case D always results in Case A
				if (relevantNode.left.RB && relevantNode.right.RB) {
					//Case A: sibling and its both children are black -> change sibling to red and move upwards
					relevantNode.RB = false;
					targetNode = targetNode.parent;
				}
				else {
					if (relevantNode.right.RB) {
						//Case B: sibling's left child is red and right child black ->
						//        swap colors between sibling and its left child, and rotate
						relevantNode.left.RB = true;
						relevantNode.RB = false;
						Rotation.rightRotation(rbt, relevantNode);
						relevantNode = targetNode.parent.right;
					}
					//Case B always results in Case C
					//Case C: sibling's right child is red and left child black ->
					//        change right child to black, swap colors between parent and sibling, and rotate
					relevantNode.RB = targetNode.parent.RB;
					targetNode.parent.RB = true;
					relevantNode.right.RB = true;
					Rotation.leftRotation(rbt, targetNode.parent);
					targetNode = rbt.getRoot(); //to stop the while-loop
				}
			}
			else { //all on the right branch
				relevantNode = targetNode.parent.left;
				if (!relevantNode.RB) {
					//Case D
					relevantNode.RB = true;
					targetNode.parent.RB = false;
					Rotation.rightRotation(rbt, targetNode.parent);
					relevantNode = targetNode.parent.left; //update the sibling, which is always black now
				}
				if (relevantNode.left.RB && relevantNode.right.RB) {
					//Case A
					relevantNode.RB = false;
					targetNode = targetNode.parent;
				}
				else {
					if (relevantNode.left.RB) {
						//Case B
						relevantNode.right.RB = true;
						relevantNode.RB = false;
						Rotation.leftRotation(rbt, relevantNode);
						relevantNode = targetNode.parent.left;
					}
					//Case C
					relevantNode.RB = targetNode.parent.RB;
					targetNode.parent.RB = true;
					relevantNode.left.RB = true;
					Rotation.rightRotation(rbt, targetNode.parent);
					targetNode = rbt.getRoot(); //to stop the while-loop
				}
			}
		}
		targetNode.RB = true; //make sure the root is black (might be unnecessary)
	}

	public static <T extends Comparable<T>> void delete(RBTree<T> rbt, T deleteKey) {
		//Core Notion: Number of black nodes shouldn't change
		Node<T> deleteNode = Search.search(rbt, deleteKey);
		//if the called-method uses <T extends Comparable<T>>, all the caller-methods should use the same
		boolean deleteNodeColor;
		
		if (deleteNode == null) {
			System.out.println("The tree does not hold a key of " + deleteKey + " to delete");
		}
		else { //deleteNode exists
			Node<T> tempNode = null;
			Node<T> targetNode = null; //the child of deleteNode / tempNode
			deleteNodeColor = deleteNode.RB;

			//First: finish the node deletion by replace()
			if (deleteNode.left == null && deleteNode.right == null) { //have no child
				if (deleteNode == deleteNode.parent.left) {
					deleteNode.parent.left = null;
				}
				else {
					deleteNode.parent.right = null;
				}
				deleteNode = null;
			}
			else if (deleteNode.left == null) { //only have right child
				targetNode = deleteNode.right;
				replace(rbt, deleteNode, targetNode);
			}
			else if (deleteNode.right == null) { //only have left child
				targetNode = deleteNode.left;
				replace(rbt, deleteNode, targetNode);
			}
			else { //have both children
				tempNode = Supplement.minimum(deleteNode.right);
				//tempNode.key is the smallest of all keys larger than deleteNode.key,
				//and tempNode could be the one to replace deleteNode in the new tree
				deleteNodeColor = tempNode.RB;
				//the actual deleteNodeColor is no longer important,
				//current tempNode is the one that might cause color violations in the new tree,
				//and targetNode is the bottom node that might have color violation
				
				//the right branch of deleteNode needs to be deal with differently
				
				targetNode = tempNode; //tempNode could only have right child or no child
				if (tempNode.parent != deleteNode) { //tempNode has a right child
					replace(rbt, tempNode, tempNode.right); //use its child to fill in its place
					tempNode.right = deleteNode.right;
					tempNode.right.parent = tempNode;
				}
				
				//Sentences from "deleteNodeColor = ..." till now could be replaced by "delete(rbt, tempNode);"
				//the left branch of deleteNode always needs to be deal with in the same way
				replace(rbt, deleteNode, tempNode);
				tempNode.left = deleteNode.left;
				tempNode.left.parent = tempNode;
				tempNode.RB = deleteNode.RB; //"inherit" deleteNode's color
			}

			//Second: arrange the color of nodes after deletion
			if (deleteNodeColor) { //deleteNodeColor is black
				//if deleteNodeColor is red, then deletion leaves no rule violation, so all colors are set
				arrange(rbt, targetNode);
			}
		}
	}

}
