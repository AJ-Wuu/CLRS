/**
 * @author AJWuu
 */

package fibonacciHeaps;

public class Min {

	//Minimum
	public static int getMin(FibonacciHeap fh) {
		return fh.min.key;
	}

	//Extract Minimum
	public static void extractMin(FibonacciHeap fh) {
		FiboNode min = fh.min;
		if (min != null) {
			FiboNode child = min.child;
			FiboNode temp = child;
			FiboNode parent;
			if (child != null) { //add children to the root list of fh
				do {
					parent = child.right;
					Insert.insertNode(fh, child);
					child.parent = null;
					child = parent;
				} while (child != null && child != temp);
			}
			min.left.right = min.right;
			min.right.left = min.left;
			min.child = null;

			if (min == min.right) { //remove min from the root list of fh
				fh.min = null;
			}
			else {
				fh.min = min.right;
				consolidation(fh);
			}
			fh.num--;
		}
	}

	public static void consolidation(FibonacciHeap fh) {
		int index;
		int number = (int)(Math.log(fh.num) / Math.log((1 + Math.sqrt(5)) / 2)); //the upper bound
		FiboNode[] arrayNodes = new FiboNode[number+1];
		for (int i=0; i<=number; i++) {
			arrayNodes[i] = null;
		}

		FiboNode node1 = fh.min, node2, check;
		if (node1 != null) {
			check = fh.min;
			do {
				index = node1.degree;
				while (arrayNodes[index] != null) {
					node2 = arrayNodes[index];
					if (node1.key > node2.key) {
						//swap
						FiboNode temp = node1;
						node1 = node2;
						node2 = temp;
					}

					link(fh, node1, node2);
					check = node1;
					arrayNodes[index] = null;
					index++;
				}
				arrayNodes[index] = node1;
				node1 = node1.right;
			} while (node1 != null && node1 != check);

			fh.min = null;
			for (int j=0; j<=number; j++) {
				if (arrayNodes[j] != null) {
					Insert.insertNode(fh, arrayNodes[j]);
				}
			}
		}
	}

	public static void link(FibonacciHeap fh, FiboNode node1, FiboNode node2) {
		//remove node2 from the root list of fh
		node2.left.right = node2.right;
		node2.right.left = node2.left;
		if (node1.child == null) {
			node2.left = node2;
			node2.right = node2;
		}
		else {
			node2.right = node1.child;
			node2.left = node1.child.left;
			node1.child.left.right = node2;
			node1.child.left = node2;
		}

		//make node2 a child of node1
		node2.parent = node1;
		node1.child = node2;
		node1.degree++;
		node2.mark = false;
	}

}
