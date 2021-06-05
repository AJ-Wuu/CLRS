/**
 * @author AJWuu
 */

package redBlackTrees;

public class Rotation {

	public static <T> void leftRotation(RBTree<T> rbt, Node<T> unbalancedNode) {
		//First: change kids
		Node<T> helperNode = unbalancedNode.right; //relation between unbalancedNode and helperNode
		unbalancedNode.right = helperNode.left; //make helperNode's left branch as unbalancedNode's right branch
		if (helperNode.left != null) { //not null then also needs to change left branch's parent
			helperNode.left.parent = unbalancedNode;
		}
		
		//Second: change parents
		helperNode.parent = unbalancedNode.parent; //move helperNode to unbalancedNode's previous place
		if (unbalancedNode.parent == null) { //unbalancedNode was the root
			rbt.setRoot(helperNode);
		}
		else if (unbalancedNode == unbalancedNode.parent.left) {
			//whether unbalancedNode is the left or right branch of its parent
			unbalancedNode.parent.left = helperNode;
		}
		else {
			unbalancedNode.parent.right = helperNode;
		}
		
		//Third: change the relation between both targets
		helperNode.left = unbalancedNode;
		unbalancedNode.parent = helperNode;
	}
	
	public static <T> void rightRotation(RBTree<T> rbt, Node<T> unbalancedNode) {
		Node<T> helperNode = unbalancedNode.left;
		unbalancedNode.left = helperNode.right;
		if (helperNode.right != null) {
			helperNode.right.parent = unbalancedNode;
		}
		
		helperNode.parent = unbalancedNode.parent;
		if (unbalancedNode.parent == null) {
			rbt.setRoot(helperNode);
		}
		else if (unbalancedNode == unbalancedNode.parent.left) {
			unbalancedNode.parent.left = helperNode;
		}
		else {
			unbalancedNode.parent.right = helperNode;
		}
		
		helperNode.right = unbalancedNode;
		unbalancedNode.parent = helperNode;
	}
	
}
