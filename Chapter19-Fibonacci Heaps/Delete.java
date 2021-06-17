/**
 * @author AJWuu
 */

package fibonacciHeaps;

public class Delete {

	static int NINF = Integer.MIN_VALUE;
	
	public static void delete(FibonacciHeap fh, int key) {
		FiboNode x = Search.search(fh.min, key);
		if (x == null) {
			return ;
		}
		//make x the minNode of fh by giving it the key of NINF
		DecreaseKey.decreaseKey(fh, x, NINF);
		//then removes the minNode (x)
		Min.extractMin(fh);
	}
	
}
