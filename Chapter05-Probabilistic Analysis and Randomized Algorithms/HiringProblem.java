/**
 * @author AJWuu
 */

package hiringProblem;

import java.util.Random;

public class HiringProblem {
	
	private static void swap(int[] array, int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
	
	private static void shuffle(int[] array) {
		Random randomArray = new Random();
		int random = 0;
		for (int i=array.length; i>0; i--) {
			random = randomArray.nextInt(i);
			swap(array, random, i-1);
		}
	}
	
	public static void main(String[] args) {
		int n = 20;
		int current = 9;
		int[] candidates = new int[n];
		
		//Random array of the candidates
		for (int i=0; i<n; i++) {
			candidates[i] = i+1;
		}
		shuffle(candidates);
		
		for (int j=0; j<n; j++) {
			if (candidates[j] > current) {
				System.out.println("The selected candidate for this turn is No." + candidates[j]);
				break;
			}
		}
	}
  
}
