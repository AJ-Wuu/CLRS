/**
 * @author AJWuu
 */

package proto;

public class TestTree {

	public static void main(String[] args) {
		protovEB tree = new protovEB(16);
		System.out.println("Check if key = 2 is in the tree: " + Member.isMember(tree, 2));
		System.out.println("Insert key = 0, 1, 2, 3");
		Insert.insert(tree, 1);
		Insert.insert(tree, 2);
		Insert.insert(tree, 13);
		Insert.insert(tree, 0);
		System.out.println("Check if key = 2 is in the tree: " + Member.isMember(tree, 2));
		System.out.println("The minimum of the tree has key = " + Compare.minimum(tree));
		System.out.println("The maximum of the tree has key = " + Compare.maximum(tree));
		System.out.println("The predecessor of key = 2 is key = " + Predecessor.predecessor(tree, 2));
		System.out.println("The successor of key = 2 is key = " + Successor.successor(tree, 2));
		System.out.println("Delete key = 0, 3");
		Delete.delete(tree, 0);
		Delete.delete(tree, 13);
		System.out.println("Check if key = 0 is in the tree: " + Member.isMember(tree, 0));
		System.out.println("Check if key = 13 is in the tree: " + Member.isMember(tree, 3));
		System.out.println("The minimum of the tree changes to: key = " + Compare.minimum(tree));
		System.out.println("The maximum of the tree changes to: key = " + Compare.maximum(tree));
	}

}
