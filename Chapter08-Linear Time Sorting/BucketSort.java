/**
 * @author AJWuu
 */

package bucketSort;

import java.util.Collections;
import java.util.Vector;

public class BucketSort {

	public static void sort(double[] array) {
		int n = array.length;
		if (n <= 0) {
			return ;
		}
		
		//Create empty buckets
		Vector<Double>[] buckets = new Vector[n];
		for (int i=0; i<n; i++) {
			buckets[i] = new Vector<Double>();
		}
		
		//Put elements in corresponding buckets
		for (int i=0; i<n; i++) {
			double index = array[i] * n;
			buckets[(int)index].add(array[i]);
		}
		
		//Sort individual bucket
		for (int i=0; i<n; i++) {
			Collections.sort(buckets[i]);
		}
		
		//Concatenate all the buckets
		int index = 0;
		for (int j=0; j<n; j++) {
			for (int k=0; k<buckets[j].size(); k++) {
				array[index++] = buckets[j].get(k);
			}
		}
	}
	
	static void print(double[] array) {
		for (int i=0; i<array.length; i++) {
			System.out.print(array[i] + " ");
		}
	}
	
	public static void main(String[] args) {
		double[] array = {0.897, 0.565, 0.656, 0.1234, 0.665, 0.3434};
		
		sort(array);
		
		System.out.print("Sorted Array: ");
		print(array);
		System.out.println();
	}

}
