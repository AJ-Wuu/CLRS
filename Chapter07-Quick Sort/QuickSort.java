/**
 * @author AJWuu
 */

package quickSort;

public class QuickSort {

	public void sort(int[] array, int low, int high) {
		if (low < high) {
			int pivot = partition(array, low, high);
			sort(array, low, pivot-1);
			sort(array, pivot+1, high);
		}
	}
	
	static int partition(int[] array, int low, int high) {
		int pivot = array[high];
		int index = low - 1;
		for (int k=low; k<high; k++) {
			if (array[k] < pivot) {
				index++;
				swap(array, k, index);
			}
		}
		swap(array, index+1, high);
		return (index + 1);
	}
	
	static void swap(int[] array, int a, int b) {
		int temp = array[a];
		array[a] = array[b];
		array[b] = temp;
	}
	
	static void PrintArray(int[] array) {
		int n = array.length;
		for (int i=0; i<n; i++) {
			System.out.print(array[i] + " ");
		}
	}
	
	public static void main(String[] args) {
		int[] array = {13,19,9,5,12,8,7,4,21,2,6,11};
		int n = array.length;
		
		QuickSort result = new QuickSort();
		result.sort(array, 0, n-1);
		
		System.out.print("The sorted array: ");
		PrintArray(array);
		System.out.println();
	}

}
