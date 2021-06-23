/**
 * @author AJWuu
 */

package heapSort;

public class Extract {
	
	private int[] array;
	
	public Extract(int[] array) {
		this.array = array;
	}
	
	public static int ExtractMax(int[] array) {
		int heapSize = array.length;
		if (heapSize < 1) {
			System.out.println("ERROR: heap underflow");
		}
		int max = array[0];
		array[0] = array[heapSize-1];
		heapSize--;
		MaxHeap.MaxHeapify(array, 0, heapSize);
		return max;
	}
}
