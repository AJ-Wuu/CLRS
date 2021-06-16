/**
 * @author AJWuu
 */

package bTrees;

class BTNode {
	int minDegree;
	int[] keys;
	int n; //current number of keys
	BTNode[] children;
	boolean isLeaf;
	
	public BTNode() {
		this.minDegree = 0;
		this.isLeaf = true;
		this.keys = new int[0];
		this.children = new BTNode[0];
		this.n = 0;
	}

	public BTNode(int minDegree, boolean isLeaf) {
		this.minDegree = minDegree;
		this.isLeaf = isLeaf;
		this.keys = new int[2 * minDegree - 1];
		this.children = new BTNode[2 * minDegree];
		this.n = 0;
	}
}

public class BTree {
	public BTNode root;
	public int minDegree;
	
	public BTree(int minDegree) {
		this.root = new BTNode(minDegree, true);
		this.minDegree = minDegree;
	}
	
	public BTNode getRoot() {
		return root;
	}
	
	public void setRoot(BTNode root) {
		this.root = root;
	}
	
	public int getT() {
		return minDegree;
	}
}
