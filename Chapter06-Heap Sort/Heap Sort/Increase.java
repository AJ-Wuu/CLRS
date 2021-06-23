/**
 * @author AJWuu
 */

package heapSort;

public class Increase {
	
	private int[] array;
	private int i;
	private int key;
	
	public Increase(int[] array, int i, int key) {
		this.array = array;
		this.i = i;
		this.key = key;
	}
	
	public static void IncreaseKey(int[] array, int i, int key) {
		if (key < array[i]) {
			System.out.println("ERROR: new key is smaller than current key");
		}
		array[i] = key;
		while (i > 1 && array[(i-1)/2] < array[i]) {
			Exchange.exchange(array, i, (i-1)/2);
			i = (i-1)/2;
		}
	}
}
