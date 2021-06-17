/**
 * @author AJWuu
 */

package fibonacciHeaps;

public class DecreaseKey {

	public static void decreaseKey(FibonacciHeap fh, FiboNode found, int key) {
		if (fh.min == null) {
			return ; //no heap
		}
		if (found == null) {
			return ; //no current key
		}
		if (found.key < key) {
			return ; //new key is greater than current key
		}
		
		found.key = key;
		FiboNode temp = found.parent;
		if (temp != null && found.key < temp.key) {
			cut(fh, found, temp);
			cascade(fh, temp);
		}
		if (found.key < fh.min.key) {
			fh.min = found;
		}
	}
	
	public static void cut(FibonacciHeap fh, FiboNode found, FiboNode temp) {
		//remove found from the child list of temp
		if (found == found.left) {
			temp.child = null;
		}
		found.left.right = found.right;
		found.right.left = found.left;
		if (found == temp.child) {
			temp.child = found.right;
		}
		temp.degree--;
		
		//add found to the root list of fh
		found.right = found;
		found.left = found;
		fh.min.left.right = found;
		found.right = fh.min;
		found.left = fh.min.left;
		fh.min.left = found;
		
		found.parent = null;
		found.mark = false;
	}
	
	public static void cascade(FibonacciHeap fh, FiboNode temp) {
		FiboNode curr = temp.parent;
		if (curr != null) {
			if (temp.mark == false) {
				temp.mark = true;
			}
			else {
				cut(fh, temp, curr);
				cascade(fh, curr);
			}
		}
	}
	
}
