/**
 * @author AJWuu
 */

package randomizedSelect;

import java.util.Random;
import java.util.Scanner;

public class RandomizedSelect_Recursive {

	static void RandomNumber(int[] array, int begin, int end) {
		Random rand = new Random();
		int pivot = rand.nextInt(end - begin) + begin;
		swap(array, pivot, end);
	}
	
	static void swap(int[] array, int a, int b) {
		int temp = array[a];
		array[a] = array[b];
		array[b] = temp;
	}
	
	static int RandomizedPartition(int[] array, int begin, int end) {
		RandomNumber(array, begin, end);
		int pivot = array[end];
		int i = begin - 1;
		for (int j=begin; j<=end; j++) {
			if (array[j] < pivot) {
				i++;
				swap(array, i, j);
			}
		}
		swap(array, i+1, end);
		return (i+1);
	}
	
	public static int RandomizedSelect(int[] array, int begin, int end, int index) {
		if (begin == end) {
			return array[begin];
		}
		int pivot = RandomizedPartition(array, begin, end);
		int length = pivot - begin + 1;
		
		if (index == length) {
			return array[pivot];
		}
		else if (index < length) {
			return RandomizedSelect(array, begin, pivot-1, index);
		}
		else {
			return RandomizedSelect(array, pivot+1, end, index);
		}
	}
	
	public static void main(String[] args) {
		int[] array = {3, 2, 9, 0, 7, 5, 4, 8, 6, 1};
		
		//The x-th smallest number of the array
		System.out.print("Enter the x-th smallest number of target: x = ");
		Scanner in = new Scanner(System.in);
		int index = in.nextInt();
		in.close();
		
		int result = RandomizedSelect(array, 0, array.length-1, index);
		System.out.println(result);
	}

}
