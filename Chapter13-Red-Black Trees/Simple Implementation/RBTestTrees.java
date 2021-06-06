/**
 * @author AJWuu
 */

package redBlackTrees;

public class RBTestTrees {

	public static void main(String[] args) {
		int[] nodes = new int[] {7,3,18,10,22,8,11,26,2,6,13};
		RBTree<Integer> tree = new RBTree<Integer>();
		for (int i : nodes) {
			Insert.insert(tree, i);
		}
		
		System.out.println("*************Begin*************\n");
		
		System.out.println("***********Traversal***********");
		System.out.print("MidOrder: ");
		Supplement.midOrder(tree.getRoot());
		System.out.print("\n");

		System.out.println("\n************Insert*************");
		Insert.insert(tree, 1);
		Insert.insert(tree, 21);
		Insert.insert(tree, 31);
		System.out.print("Insert Results (1, 21, 31) in MidOrder: ");
		Supplement.midOrder(tree.getRoot());
		System.out.print("\n");
		
		System.out.println("\n************Search*************");
		System.out.println("Search for 1: " + Search.search(tree, 1));
		System.out.println("Search for 2: " + Search.search(tree, 2));
		System.out.println("Search for 17: " + Search.search(tree, 12));
		System.out.println("Search for 21: " + Search.search(tree, 21));
		
		System.out.println("\n************Delete*************");
		Delete.delete(tree, 3);
		Delete.delete(tree, 10);
		Delete.delete(tree, 31);
		Delete.delete(tree, 41);
		System.out.print("Delete Results (3, 10, 31) in MidOrder: ");
		Supplement.midOrder(tree.getRoot());
		System.out.print("\n");
		
		System.out.println("\n**************End**************");
	}

}
