/**
 * @author AJWuu
 */

package openAddressing;

import java.util.Hashtable;

class group {
	int key;
	int valid;
	int value;

	public group(int key, int valid, int value) {
		this.key = key;
		this.valid = valid;
		this.value = value;
	}
}

public class OpenAddressing {
  
	static int SIZE = 10;
	static double random = SIZE * Math.random(); //Math.random() gets value from 0.0 ~ 1.0

	static int hashCode(int key) {
		//Linear Probing
		return (int)(key + random) % SIZE;
		
		//Quadratic Probing
//		double c1 = Math.random();
//		double c2 = Math.random();
//		return (int)(key + c1 * random + c2 * random * random) % SIZE;
		
		//Double Hashing
		//return (int)((1 + key) % (SIZE - 1) + random) % SIZE;
	}

	static void initialize(Hashtable<Integer, group> ht) {
		group initGroup;
		for (int i=0; i<SIZE; i++) {
			initGroup = new group(0, 0, 0);
			ht.put(i, initGroup);
		}
	}

	static void insert(Hashtable<Integer, group> ht, int key, int value) {
		int index = hashCode(key);
		while (true) {
			if (index >= SIZE) { //target index out of bounds
				System.out.println("insert failed");
				break;
			}
			
			if (ht.get(index).valid == 0) { //Invalid
				ht.get(index).key = key;
				ht.get(index).valid = 1;
				ht.get(index).value = value;
				break;
			}
			else {
				index++;
			}
		}
	}

	static void delete(Hashtable<Integer, group> ht, int key) {
		int index = hashCode(key);
		while (true) {
			if (index >= SIZE) { //target index out of bounds
				System.out.println("delete failed");
				break;
			}
			
			if (ht.get(index).key == key) {
				ht.get(index).valid = 0;
				break;
			}
			else {
				index++;
			}
		}
	}

	static group search(Hashtable<Integer, group> ht, int key) {
		int index = hashCode(key);
		group notFoundGroup = new group(0, 0, 0);
		
		while (true) {
			if (index >= SIZE) { //target index out of bounds
				System.out.println("search failed");
				return notFoundGroup;
			}

			if (ht.get(index).key == key) { //same key
				if (ht.get(index).valid != 0) { //valid
					return ht.get(index);
				}
				else {
					index++;
				}
			}
			else { //invalid
				return notFoundGroup;
			}
		}
	}

	public static void main(String[] args) {
		Hashtable<Integer, group> ht = new Hashtable<Integer, group>(SIZE);
		//Initialize
		initialize(ht);
		
		insert(ht, 1, 1);
		insert(ht, 2, 2);
		insert(ht, 2, 20);
		insert(ht, 3, 3);
		insert(ht, 6, 6);
		search(ht, 2);
		search(ht, 3);
		search(ht, 6);
		delete(ht, 2);
		delete(ht, 3);
	}

}
