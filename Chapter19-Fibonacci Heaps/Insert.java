/**
 * @author AJWuu
 */

package fibonacciHeaps;

public class Insert {

	public static void insertKey(FibonacciHeap fh, int key) {
		FiboNode x = new FiboNode(key, 0, false, null, null, null, null);
		insertNode(fh, x);
	}
	
	public static void insertNode(FibonacciHeap fh, FiboNode x) {
		if (fh.min == null) {
			fh.min = x;
			x.left = x; //self-loop
			x.right = x;
		}
		else {
			//insert x to the right of minNode
			fh.min.left.right = x;
			x.left = fh.min.left;
			x.right = fh.min;
			fh.min.left = x;
			if (x.key < fh.min.key) {
				fh.min = x;
			}
		}
		fh.num++;
	}
	
}
