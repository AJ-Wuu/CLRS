/**
 * @author AJWuu
 */

package quickSelect;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Random;

//Quickselect (Hoare's Selection Algorithm)
//It's typically used to solve the problems "find kth something": kth smallest, kth largest, kth most frequent, kth less frequent, etc.
//It has O(N) average time complexity. Though its worth case time complexity is O(N^2), the probability of this worst-case is negligible.
public class QuickSelect {

	static int[] unique;
	static HashMap<Integer, Integer> count;

	public static void swap(int a, int b) {
		int tmp = unique[a];
		unique[a] = unique[b];
		unique[b] = tmp;
	}

	//Lomuto's Partition Scheme
	//Note that this method only makes sure that elements on the left side of pivot is less than pivot and right side equal or more than pivot.
	//However, it does not guarantee that the left / right side is formed in ascending order (it's actually "random").
	//Eg. (Element-Frequency) 7-2, 10-5, 3-6, 9-2, 4-1, 2-4 -> Ordered by frequency with pivot = 2 -> 7-2, 9-2, 4-1, 2-4, 3-6, 10-5
	//Steps:
	//1. Move pivot at the end of the array using swap
	//2. Set the pointer at the beginning of the array store_index = left
	//3. Iterate over the array and move all less frequent elements to the left swap(store_index, i). Move store_index one step to the right after each swap
	//4. Move the pivot to its final place, and return this index
	public static int partition(int left, int right, int pivot_index) {
		int pivot_frequency = count.get(unique[pivot_index]);
		//Step 1
		swap(pivot_index, right);
		int store_index = left;

		//Step 2
		for (int i=left; i<=right; i++) {
			if (count.get(unique[i]) < pivot_frequency) {
				//Step 3
				swap(store_index, i);
				store_index++;
			}
		}

		//Step 4
		swap(store_index, right);
		return store_index;
	}

	public static void quickselect(int left, int right, int k_smallest) {
		//Sort a list within [left, right] till kth less frequent element takes its place
		//Base case -- only one element
		if (left == right) {
			return ;
		}

		//Select a random pivot_index
		Random random_num = new Random();
		int pivot_index = left + random_num.nextInt(right - left); 

		//Find the pivot position in a sorted list
		pivot_index = partition(left, right, pivot_index);

		//the pivot is in its final sorted position
		if (k_smallest == pivot_index) {
			return;    
		} else if (k_smallest < pivot_index) {
			//Go left
			quickselect(left, pivot_index - 1, k_smallest);     
		} else {
			//Go right 
			quickselect(pivot_index + 1, right, k_smallest);  
		}
	}

	public static int[] topKFrequent(int[] nums, int k) {
		//Build HashMap<Element, Frequency>
		count = new HashMap<Integer, Integer>();
		for (int num: nums) {
			count.put(num, count.getOrDefault(num, 0) + 1);
		}

		//array of unique elements
		int n = count.size();
		unique = new int[n]; 
		int i = 0;
		for (int num: count.keySet()) {
			unique[i] = num;
			i++;
		}

		//Partial sort: from less frequent to the most frequent, till (n - k)th less frequent element takes its place (n - k) in a sorted array
		quickselect(0, n-1, n-k); //kth top frequent element is (n - k)th less frequent
		return Arrays.copyOfRange(unique, n-k, n);
	}

	public static void main(String[] args) {
		int[] nums = {1,1,2,3,4,5,1,1,2,2,3};
		int[] result = topKFrequent(nums, 3);
		for (int i : result) {
			System.out.print(i + " ");
		}
	}

}
