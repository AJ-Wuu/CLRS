/**
 * @author AJWuu
 */

package heapSort;

public class Insert {
	 
	private int[] array;
	private int key;
	
	public Insert(int[] array, int key) {
		this.array = array;
		this.key = key;
	}
	
	public static void InsertKey(int[] array, int key) {
		int heapSize = array.length - 1;
		heapSize++;
		array[heapSize] = -1/0; //-∞
		Increase.IncreaseKey(array, heapSize, key);
	}
}
