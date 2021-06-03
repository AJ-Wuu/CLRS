/**
 * @author AJWuu
 */

package binarySearchTrees;

class Node<T> {
	T key;
	Node<T> left;
	Node<T> right;
	
	public Node(T key) {
		this.key = key;
	}
	
	public Node(T key, Node<T> left, Node<T> right) {
		this.key = key;
		this.left = left;
		this.right = right;
	}
}

public class BinarySearchTree<T> {
	private Node<T> root;
	
	public BinarySearchTree() {
		this.root = null;
	}
	
	public Node<T> getRoot() {
		return this.root;
	}
	
	public void setRoot(Node<T> root) {
		this.root = root;
	}
}
