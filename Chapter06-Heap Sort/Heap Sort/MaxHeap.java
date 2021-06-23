/**
 * @author AJWuu
 */

package heapSort;

public class MaxHeap {
	
	private int[] array;
	private int n;
	
	public MaxHeap(int[] array, int n) {
		this.array = array;
		this.n = n;
	}
	
	public static void MaxHeapify(int[] array, int index, int heapSize) {
		int left = index * 2 + 1;
		int right = index * 2 + 2;
		int largest = index;
		if (left <= heapSize && array[left] > array[index]) {
			largest = left;
		}
		if (right <= heapSize && array[right] > array[largest]) {
			largest = right;
		}
		if (largest != index) {
			Exchange.exchange(array, index, largest);
			MaxHeapify(array, largest, heapSize);
		}
	}
}
