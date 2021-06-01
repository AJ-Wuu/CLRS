package hashTable;

import java.util.Hashtable;
import java.util.LinkedList;

class Node {
	//need to create an instance of outer class first,
	//then create an instance of inner class
	int data;
	Node prev;
	Node next;
	
	public Node(int d) {
		this.data = d;
		prev = null;
		next = null;
	}
}

public class HashTable {
	static int SIZE = 10;

	static int hashCode(int key) {
		return key % SIZE;
	}

	static void insert(Hashtable<Integer, LinkedList<Node>> ht1, int key, int data) {
		int hashIndex = hashCode(key);
		Node DATA = new Node(data);
		if (ht1.containsKey(hashIndex)) { //already has element
			Node tempNode = (Node) ht1.get(hashIndex).get(0);
			while (tempNode.next != null) {
				tempNode = tempNode.next;
			}
			tempNode.next = DATA;
			DATA.prev = tempNode;
		}
		else { //no element
			LinkedList<Node> tempList = new LinkedList<Node>();
			tempList.add(DATA);
 			ht1.put(hashIndex, tempList);
		}
	}

	static void delete(Hashtable<Integer, LinkedList<Node>> ht1, int key, int data) {
		int hashIndex = hashCode(key);
		if (ht1.containsKey(hashIndex)) {
			LinkedList<Node> tempList = ht1.get(hashIndex);
			Node tempNode = (Node) tempList.get(0);
			if (tempNode.next == null) { //only one element
				ht1.remove(hashIndex);
			}
			else { //has more than one element
				while (tempNode != null) {
					if (tempNode.data == data) { //find the corresponding node
						if (tempNode.prev == null) { //the first node
							tempNode.next.prev = null;
							tempList.clear();
							tempList.addFirst(tempNode.next);
						}
						else if (tempNode.next == null) { //the last node
							tempNode.prev.next = null;
						}
						else { //node in the middle
							tempNode.prev.next = tempNode.next;
							tempNode.next.prev = tempNode.prev;
						}
					}
					tempNode = tempNode.next;
				}
			}
		}
	}

	static int search(Hashtable<Integer, LinkedList<Node>> ht1, int key) {
		int hashIndex = hashCode(key);
		if (ht1.containsKey(hashIndex)) {
			Node curr = (Node)ht1.get(hashIndex).get(0);
			return curr.data;
		}
		return 0;
	}

	public static void main(String[] args) {
		Hashtable<Integer, LinkedList<Node>> ht1 = new Hashtable<Integer, LinkedList<Node>>(SIZE);
		Hashtable<Integer, LinkedList<Node>> ht2 = new Hashtable<Integer, LinkedList<Node>>(SIZE);

		insert(ht1, 3, 30);
		insert(ht1, 5, 50);
		delete(ht1, 3, 30);
		System.out.println(search(ht1, 1));
		
		insert(ht2, 4, 40);
		insert(ht2, 2, 20);
		insert(ht2, 2, 200);
		insert(ht2, 2, 2000);
		insert(ht2, 2, 20000);
		insert(ht2, 2, 200000);
		delete(ht2, 2, 20);
		delete(ht2, 2, 200000);
		delete(ht2, 2, 2000);
		System.out.println(search(ht2, 2));
	}

}
