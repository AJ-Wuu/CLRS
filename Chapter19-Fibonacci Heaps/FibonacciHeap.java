/**
 * @author AJWuu
 */

package fibonacciHeaps;

class FiboNode {
	int key; //it's own value
	int degree; //number of children
	boolean mark; //mark if it has lost a child
	FiboNode child; //any one of the children
	FiboNode left; //left sibling
	FiboNode right; //right sibling
	FiboNode parent;
	
	public FiboNode(int key, int degree, boolean mark, FiboNode child, FiboNode left, FiboNode right, FiboNode parent) {
		this.key = key;
		this.degree = degree;
		this.mark = mark;
		this.child = child;
		this.left = left;
		this.right = right;
		this.parent = parent;
	}
}

public class FibonacciHeap {
	int num; //number of FiboNodes in the heap
	int maxDegree; //the maximum number of degree
	FiboNode min; //minimum FiboNode, also the root
	FiboNode found; //the last FiboNode

	public FibonacciHeap(int num, int maxDegree, FiboNode min, FiboNode found) {
		this.num = num;
		this.maxDegree = maxDegree;
		this.min = min;
		this.found = found;
	}
}
