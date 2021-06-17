/**
 * @author AJWuu
 */

package fibonacciHeaps;

public class TestHeap {

	public static void main(String[] args) {
		FibonacciHeap heap = new FibonacciHeap(0, 0, null, null);
		Insert.insertKey(heap, 4);
		Insert.insertKey(heap, 3);
		Insert.insertKey(heap, 7);
		Insert.insertKey(heap, 5);
		Insert.insertKey(heap, 2);
		Insert.insertKey(heap, 1);
		Insert.insertKey(heap, 10);

		System.out.println("**************Begin**************");
		Display.display(heap.min);
		System.out.println();
		
		System.out.println("\n**************Insert*************");
		Insert.insertKey(heap, 6);
		Insert.insertKey(heap, 9);
		Insert.insertKey(heap, 8);
		Display.display(heap.min);
		System.out.println();
		
		System.out.println("\n***********Extract Min***********");
		Min.extractMin(heap);
		Display.display(heap.min);
		System.out.println();
		
		System.out.println("\n**************Search*************");
		System.out.println("Search for key = 2: " + Search.search(heap.min, 2));
		System.out.println("Search for key = 9: " + Search.search(heap.min, 9));
		System.out.println("Search for key = 12: " + Search.search(heap.min, 12));
		
		Display.display(heap.min);
		System.out.println();
		System.out.println("\n**************Delete*************");
		Delete.delete(heap, 7);
		Display.display(heap.min);
		System.out.println();
		
		System.out.println("\n*************The End*************");
	}

}
