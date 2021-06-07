/**
 * @author AJWuu
 */

package intervalTree;

class interval<T> {
	T low;
	T high;
	
	public interval(T low, T high) {
		this.low = low;
		this.high = high;
	}
}

class ITNode<T> {
	boolean color;
	interval<T> interval;
	T max; //maximum high value in subtree rooted with this node
	ITNode<T> left;
	ITNode<T> right;
	ITNode<T> parent;
	
	public ITNode(boolean bool, interval<T> interval, T max, ITNode<T> left, ITNode<T> right, ITNode<T> parent) {
		this.color = bool;
		this.interval = interval;
		this.max = max;
		this.left = left;
		this.right = right;
		this.parent = parent;
	}
	
	public ITNode(boolean bool, T low, T high, T max, ITNode<T> left, ITNode<T> right, ITNode<T> parent) {
		this.color = bool;
		this.interval.low = low;
		this.interval.high = high;
		this.max = max;
		this.left = left;
		this.right = right;
		this.parent = parent;
	}
}

public class IntervalTree<T> {
	private ITNode<T> root;
	
	public IntervalTree() {
		this.root = null;
	}
	
	public ITNode<T> getRoot() {
		return root;
	}
	
	public void setRoot(ITNode<T> Node) {
		this.root = Node;
	}
}
