/**
 * @author AJWuu
 */

package redBlackTrees;

class Node<T> {
	boolean RB; //TRUE is black and FALSE is red
	T key;
	Node<T> left;
	Node<T> right;
	Node<T> parent;
	
	public Node(boolean bool, T key, Node<T> left, Node<T> right, Node<T> parent) {
		this.RB = bool;
		this.key = key;
		this.left = left;
		this.right = right;
		this.parent = parent;
	}
}

public class RBTree<T> {
	private Node<T> root;
	
	public RBTree() {
		this.root = null;
	}
	
	public Node<T> getRoot() {
		return root;
	}
	
	public void setRoot(Node<T> root) {
		this.root = root;
	}
	
	public void setRootColor(boolean bool) {
		this.root.RB = bool;
	}
}
