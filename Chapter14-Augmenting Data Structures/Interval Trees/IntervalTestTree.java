/**
 * @author AJWuu
 */

package intervalTree;

public class IntervalTestTree {
	
	public static void main(String[] args) {
		int boundaries[] = {15,20,10,30,17,19,5,20,12,15,30,40,6,7,3,4};
		IntervalTree<Integer> tree = new IntervalTree<Integer>();
		
		interval<Integer> Interval = null;
		for (int i=0; i<boundaries.length; i+=2) {
			Interval = new interval<Integer>(boundaries[i], boundaries[i+1]);
			Insert.insert(tree, Interval);
		}
		
		System.out.println("*************Begin*************\n");
		
		System.out.println("***********Traversal***********");
		System.out.print("inOrder: ");
		Supplement.inOrder(tree.getRoot());
		System.out.print("\n");

		System.out.println("\n************Insert*************");
		Interval = new interval<Integer>(1, 2);
		//Interval here is passed by pointer,
		//so if we don't make it as a new interval<Integer>,
		//the tree will also change (for this, the first node will change to [1,2) from [3,4))
		Insert.insert(tree, Interval);
		Interval = new interval<Integer>(21, 31);
		//for this, both places for [1,2) and [3,4) will change to [21,31)
		Insert.insert(tree, Interval);
		Interval = new interval<Integer>(55, 66);
		Insert.insert(tree, Interval);
		System.out.print("Insert Results ([1,2), [21,31), [55,66)) in InOrder: ");
		Supplement.inOrder(tree.getRoot());
		System.out.print("\n");
		
		System.out.println("\n************Search*************");
		Interval = new interval<Integer>(15, 20);
		System.out.println("Search Exact for [15,20): " + Search.searchExact(tree, Interval));
		Interval = new interval<Integer>(21, 31);
		System.out.println("Search Exact for [21,31): " + Search.searchExact(tree, Interval));
		Interval = new interval<Integer>(12, 13);
		System.out.println("Search First Overlap for [12,13): " + Search.firstOverlap(tree, Interval));
		Interval = new interval<Integer>(12, 18);
		System.out.print("Search All Overlap for [12,18): ");
		Search.allOverlap(tree, tree.getRoot(), Interval);
		System.out.print("\n");
		Interval = new interval<Integer>(12, 20);
		System.out.print("Search All Same High for [12,20): ");
		Search.allSameHigh(tree, tree.getRoot(), Interval);
		System.out.print("\n");
		
		System.out.println("\n************Delete*************");
		Interval = new interval<Integer>(1, 2);
		Delete.delete(tree, Interval);
		Interval = new interval<Integer>(10, 30);
		Delete.delete(tree, Interval);
		Interval = new interval<Integer>(17, 19);
		Delete.delete(tree, Interval);
		Interval = new interval<Integer>(55, 66);
		Delete.delete(tree, Interval);
		System.out.print("Delete Results ([1,2), [10,30), [17,19), [55,66)) in InOrder: ");
		Supplement.inOrder(tree.getRoot());
		System.out.print("\n");
		
		System.out.println("\n**************End**************");

	}

}
