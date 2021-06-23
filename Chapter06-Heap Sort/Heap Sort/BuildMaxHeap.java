/**
 * @author AJWuu
 */

package heapSort;

public class BuildMaxHeap {
	
	private int[] array;
	
	public BuildMaxHeap(int[] array) {
		this.array = array;
	}
	
	public static void BuildHeap(int[] array, int heapSize) {
		for (int k=heapSize/2; k>=0; k--) {
			MaxHeap.MaxHeapify(array, k, heapSize);
		}
	}
}
