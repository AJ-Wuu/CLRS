/**
 * @author AJWuu
 */

package vEB;

public class TestTree {

	public static void main(String[] args) {
		vEB tree = new vEB(8);
		System.out.println("Check if key = 2 is in the tree: " + Member.isMember(tree, 2));
		System.out.println("Insert key = 1, 2, 3, 4");
		Insert.insert(tree, 1);
		Insert.insert(tree, 2);
		Insert.insert(tree, 3);
		Insert.insert(tree, 4);
		System.out.println("Check if key = 2 is in the tree: " + Member.isMember(tree, 2));
		System.out.println("The minimum of the tree has key = " + Compare.getMinimum(tree));
		System.out.println("The maximum of the tree has key = " + Compare.getMaximum(tree));
		System.out.println("The predecessor of key = 2 is key = " + Predecessor.predecessor(tree, 2));
		System.out.println("The successor of key = 2 is key = " + Successor.successor(tree, 2));
		System.out.println("Delete key = 1, 3");
		Delete.delete(tree, 1);
		Delete.delete(tree, 4);
		System.out.println("Check if key = 1 is in the tree: " + Member.isMember(tree, 1));
		System.out.println("Check if key = 4 is in the tree: " + Member.isMember(tree, 4));
		System.out.println("The minimum of the tree changes to: key = " + Compare.getMinimum(tree));
		System.out.println("The maximum of the tree changes to: key = " + Compare.getMaximum(tree));
		//bug free
	}

}
