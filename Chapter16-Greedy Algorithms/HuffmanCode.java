/**
 * @author AJWuu
 */

package huffmanCode;

import java.util.Comparator;
import java.util.PriorityQueue;

class huffmanNode {
	char character;
	int data;
	huffmanNode left;
	huffmanNode right;

	public huffmanNode(char character, int data, huffmanNode left, huffmanNode right) {
		this.character = character;
		this.data = data;
		this.left = left;
		this.right = right;
	}
}

//pay attention to this change to PriorityQueue
class newComparator implements Comparator<huffmanNode> {
	public int compare(huffmanNode a, huffmanNode b) {
		return (a.data - b.data); //same result as compareTo()
	}
}

public class HuffmanCode {

	static void output(huffmanNode root, String s) {
		if (root == null) {
			return ;
		}
		System.out.print(root.data + "(" + root.character + "):");
		if (!Character.isLetter(root.character)) {
			System.out.print("[sum]" + s);
		}
		else {
			System.out.print(s);
		}
		output(root.left, "l "); //indicating: left	
		output(root.right, "r "); //indicating: right
	}

	public static void main(String[] args) {
		char[] charArray = {'a','b','c','d','e','f'};
		int[] charFreq = {5,9,12,13,16,45};
		int n = charArray.length;
		PriorityQueue<huffmanNode> queue = new PriorityQueue<huffmanNode>(n, new newComparator());

		//initialize huffmanNodes and put them into the queue
		for (int i=0; i<n; i++) {
			huffmanNode node = new huffmanNode(charArray[i], charFreq[i], null, null);
			queue.add(node);
		}

		//build the tree;
		huffmanNode root = null;
		while (queue.size() > 1) {
			//get first two smallest nodes, x < y
			huffmanNode x = queue.peek();
			queue.poll();
			huffmanNode y = queue.peek();
			queue.poll();

			//create the node of x + y, and add it to queue
			huffmanNode sum = new huffmanNode('+', x.data + y.data, x, y);
			root = sum;
			queue.add(sum);
		}

		//traversal
		output(root, " ");
	}

}
