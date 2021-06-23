/**
 * @author AJWuu
 */

package heapSort;

public class Exchange {
	
	private int[] array;
	private int i;
	private int j;
	
	public Exchange(int[] array, int i, int j) {
		this.array = array;
		this.i = i;
		this.j = j;
	}
	
	public static void exchange(int[] array, int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
}
