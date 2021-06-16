/**
 * @author AJWuu
 */

package bTrees;

public class TestTree {

	public static void main(String[] args) {
		BTree tree = new BTree(3);
		int[] keys = new int[] {10,20,30,40,50};
		for (int i : keys) {
			Insert.insertKey(tree, i);
		}
		Insert.insertKey(tree, 60);
		Insert.insertKey(tree, 70);
		Insert.insertKey(tree, 80);
		Insert.insertKey(tree, 90);

		System.out.println("*************Begin*************\n");

		System.out.println("***********Traversal***********");
		System.out.print("Traversal: ");
		Traversal.traversal(tree.getRoot());
		System.out.print("\n");

		System.out.println("\n************Search*************");
		System.out.println("Search for 2: " + Search.search(tree.getRoot(), 2));
		System.out.println("Search for 10: " + Search.search(tree.getRoot(), 10));
		System.out.println("Search for 60: " + Search.search(tree.getRoot(), 60));
		System.out.println("Search for 80: " + Search.search(tree.getRoot(), 80));

		System.out.println("\n************Insert*************");
		Insert.insertKey(tree, 1);
		Insert.insertKey(tree, 2);
		Insert.insertKey(tree, 3);
		Insert.insertKey(tree, 4);
		Insert.insertKey(tree, 11);
		Insert.insertKey(tree, 12);
		Insert.insertKey(tree, 13);
		Insert.insertKey(tree, 14);
		Insert.insertKey(tree, 21);
		Insert.insertKey(tree, 22);
		Insert.insertKey(tree, 23);
		Insert.insertKey(tree, 24);
		Insert.insertKey(tree, 31);
		Insert.insertKey(tree, 32);
		Insert.insertKey(tree, 33);
		Insert.insertKey(tree, 34);
		Insert.insertKey(tree, 41);
		Insert.insertKey(tree, 42);
		Insert.insertKey(tree, 43);
		Insert.insertKey(tree, 44);
		System.out.print("Traversal after inserting (11-14, 21-24, 31-34, 41-44): ");
		Traversal.traversal(tree.getRoot());
		System.out.print("\n");

		System.out.println("\n************Delete*************");
		Delete.delete(tree, 20);
		Delete.delete(tree, 40);
		Delete.delete(tree, 42);
		Delete.delete(tree, 44);
		Delete.delete(tree, 80);
		System.out.print("Traversal after deleting (20, 40, 42, 44, 80): ");
		Traversal.traversal(tree.getRoot());
		System.out.print("\n");

		System.out.println("\n**************End**************");
		
	}
}
