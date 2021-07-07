/**
 * @author AJWuu
 */

package randomizedSelect;

import java.util.Random;
import java.util.Scanner;

public class RandomizedSelect_Iterative {

	static int Partition(int[] array, int begin, int end) {
		int pivot = array[end];
		int i = begin - 1;
		for (int k=begin; k<=end; k++) {
			if (array[k] < pivot) {
				i++;
				swap(array, i, k);
			}
		}
		swap(array, i+1, end);
		return (i+1);
	}
	
	static void swap(int[] array, int a, int b) {
		int temp = array[a];
		array[a] = array[b];
		array[b] = temp;
	}
	
	static int RandomNumber(int begin, int end) {
		Random rand = new Random();
		int pivot = rand.nextInt(end - begin) + begin;
		return pivot;
	}
	
	static int RandomizedPartition(int[] array, int begin, int end) {
		int pivot = RandomNumber(begin, end);
		swap(array, pivot, end);
		return Partition(array, begin, end);
	}
	
	public static int RandomizedSelect(int[] array, int begin, int end, int index) {
		while (true) {
			if (begin == end) {
				return array[begin];
			}
			
			int pivot = RandomizedPartition(array, begin, end);
			int length = pivot - begin + 1;
			
			if (index == length) {
				return array[pivot];
			}
			else if (index < pivot) {
				end = pivot - 1;
			}
			else {
				begin = pivot + 1;
				index = index - length + 1;
			}
		}
	}
	
	public static void main(String[] args) {
		int[] array = {3, 2, 9, 0, 7, 5, 4, 8, 6, 1};
		
		//The x-th largest number of the array
		System.out.print("Enter the x-th largest number of target: x = ");
		Scanner in = new Scanner(System.in);
		int index = in.nextInt();
		in.close();
		index = array.length - index + 1;
		
		int result = RandomizedSelect(array, 0, array.length-1, index);
		System.out.println(result);
	}

}
