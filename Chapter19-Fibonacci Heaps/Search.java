/**
 * @author AJWuu
 */

package fibonacciHeaps;

public class Search {

	public static FiboNode search(FiboNode min, int key) {
		FiboNode found = null, temp = min;
		do {
			if (temp.key == key)
				found = temp;
			else {
				if (temp.child != null) {
					found = search(temp.child, key);
				}
				temp = temp.right;
			}
		} while (temp != min && found == null);
		return found;
	}

}
