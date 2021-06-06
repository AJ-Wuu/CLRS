/**
 * @author AJWuu
 */

package binarySearchTrees;

public class TestTrees {

	public static void main(String[] args) {
		int[] nodes = new int[] {8,3,10,6,7,9,17,2,53,23};
		BinarySearchTree<Integer> tree = new BinarySearchTree<Integer>();
		for (int i : nodes) {
			// i is the element in nodes[], not the index
			InsertNode.insert(tree, i);
		}
		
		System.out.println("*************Begin*************\n");
		
		System.out.println("***********Traversal***********");
		System.out.print("PreOrder: ");
		Traversal.preOrder(tree.getRoot());
		System.out.print("\n");
		System.out.print("InOrder: ");
		Traversal.inOrder(tree.getRoot());
		System.out.print("\n");
		System.out.print("PostOrder: ");
		Traversal.postOrder(tree.getRoot());
		System.out.print("\n");
		
		System.out.println("\n************Compare************");
		System.out.println("Current Minimum: " + CompareNode.minKey(tree.getRoot()));
		System.out.println("Current Maximum: " + CompareNode.maxKey(tree.getRoot()));

		System.out.println("\n************Insert*************");
		InsertNode.insert(tree, 1);
		InsertNode.insert_recursive(tree.getRoot(), 11);
		InsertNode.insert(tree, 21);
		System.out.print("Insert Results (1, 11, 21) in InOrder: ");
		Traversal.inOrder(tree.getRoot());
		System.out.print("\n");
		
		System.out.println("\n************Delete*************");
		DeleteNode.delete(tree, 3);
		DeleteNode.delete(tree, 17);
		DeleteNode.delete(tree, 53);
		System.out.print("Delete Results (3, 17, 53) in InOrder: ");
		Traversal.inOrder(tree.getRoot());
		System.out.print("\n");
		
		System.out.println("\n************Search*************");
		System.out.println("Search for 1: " + SearchNode.search(tree, 1));
		System.out.println("Search for 2: " + SearchNode.search(tree, 2));
		System.out.println("Search for 17: " + SearchNode.search(tree, 17));
		System.out.println("Search for 21: " + SearchNode.search(tree, 21));
		
		System.out.println("\n**************End**************");
	}

}
