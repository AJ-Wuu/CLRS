/**
 * @author AJWuu
 */

package heapSort;

import java.util.Arrays;

public class HeapSort {
	
	public static void Sort(int[] array) {
		int heapSize = array.length - 1;
		BuildMaxHeap.BuildHeap(array, heapSize);
		for (int i=heapSize; i>0; i--) {
			Exchange.exchange(array, 0, i);
			heapSize--;
			MaxHeap.MaxHeapify(array, 0, heapSize);			
		}
	}
	
	public static void main(String[] args) {
		int[] heap = new int[] {3,7,2,11,3,4,9,2,18,0};
		Sort(heap);
		System.out.println(Arrays.toString(heap));
	}
}
