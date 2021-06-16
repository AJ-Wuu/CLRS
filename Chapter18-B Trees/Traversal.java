package bTrees;

public class Traversal {

	public static void traversal(BTNode root) {
		int i;
		for (i=0; i<root.n; i++) {
			if (!root.isLeaf) {
				traversal(root.children[i]);
			}
			System.out.print(root.keys[i] + " ");
		}
		if (!root.isLeaf) {
			traversal(root.children[i]);
		}
	}
	
}
