/**
 * @author AJWuu
 */

package fractionalKnapsack;

import java.util.Arrays;
import java.util.Comparator;

class item {
	int index;
	int weight;
	int value;
	double cost;
	
	public item(int index, int weight, int value) {
		this.index = index;
		this.weight = weight;
		this.value = value;
		this.cost = (double) (value / weight);
	}
}

public class FractionalKnapsack {
	
	static void tooMuchToCarry(int restCapacity, item[] array, int index) {
		
	}
	
	static double fractionalKnapsack(int[] weight, int[] value, int capacity) {
		item[] itemArray = new item[weight.length];
		for (int i=0; i<itemArray.length; i++) {
			itemArray[i] = new item(i, weight[i], value[i]);
		}
		//sorting the itemArray
    //This is a new way to try in the future
		Arrays.sort(itemArray, new Comparator<item>() {
			@Override
			public int compare(item it1, item it2) {
				return (new Double(it2.cost).compareTo(it1.cost));
			}
		});
		
		double finalVal = 0.0;
		for (int i=0; i<itemArray.length; i++) {
			if (capacity < itemArray[i].weight) {
				finalVal += itemArray[i].cost * capacity;
				break;
			}
			else {
				finalVal += itemArray[i].value;
				capacity -= itemArray[i].weight;
			}
		}
		return finalVal;
	}

    public static void main(String[] args) {
        int[] weight = {10,40,20,30};
        int[] value = {60,40,100,120};
        int capacity = 50;
        System.out.println(fractionalKnapsack(weight, value, capacity));
    } 
    
}
