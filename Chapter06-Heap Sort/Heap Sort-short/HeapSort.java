/**
 * @author AJWuu
 */

package heapSort_short;

public class HeapSort {
	
	public void sort(int[] array) {
		int n = array.length;
		//Build heap
		for (int i=n/2-1; i>=0; i--) {
			heapify(array, n, i);
		}
		//One by one extract an element from heap
		for (int j=n-1; j>0; j--) {
			swap(array, 0, j);
			heapify(array, j, 0);
		}
	}
	
	static void heapify(int[] array, int size, int index) {
		int largest = index;
		int left = 2 * index + 1;
		int right = 2 * index + 2;
		
		if (left < size && array[left] > array[largest]) {
			largest = left;
		}
		if (right < size && array[right] > array[largest]) {
			largest = right;
		}
		if (largest != index) {
			swap(array, index, largest);
			heapify(array, size, largest);
		}
	}
	
	static void swap(int[] array, int a, int b) {
		int temp = array[a];
		array[a] = array[b];
		array[b] = temp;
	}
	
	static void printArray(int[] array) {
		int n = array.length;
		for (int i=0; i<n; i++) {
			System.out.print(array[i] + " ");
		}
	}
	
	public static void main(String[] args) {
		int[] heap = {12, 11, 13, 5, 6, 7};
		HeapSort result = new HeapSort();
		result.sort(heap);
		
		System.out.print("Sorted array: ");
		printArray(heap);
		System.out.println();
	}

}
