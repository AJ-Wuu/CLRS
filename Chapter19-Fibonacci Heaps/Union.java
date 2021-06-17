/**
 * @author AJWuu
 */

package fibonacciHeaps;

public class Union {
	
	public static FibonacciHeap union(FibonacciHeap fh1, FibonacciHeap fh2) {
		FibonacciHeap fh = new FibonacciHeap(0, 0, null, null);
		fh.min = fh1.min;
		if (fh1.min != null && fh2.min != null) {
			FiboNode temp1 = fh1.min.left;
			FiboNode temp2 = fh2.min.left;
			fh1.min.left = temp2;
			temp2.right = fh1.min;
			fh2.min.left = temp1;
			temp1.right = fh2.min;
		}
		if (fh1.min == null || (fh2.min != null && fh2.min.key < fh1.min.key)) {
			fh.min = fh2.min;
		}
		fh.num = fh1.num + fh2.num;
		return fh;
	}

}
