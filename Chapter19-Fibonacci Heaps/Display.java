/**
 * @author AJWuu
 */

package fibonacciHeaps;

public class Display {

	public static void display(FiboNode min) {
		System.out.print("(");
		if (min == null) {
			System.out.print(")");
			return ;
		}
		else {
			FiboNode temp = min;
			do {
				System.out.print(temp.key);
				display(temp.child);
				System.out.print("->");
				temp = temp.right;
			} while (temp != min);
			System.out.print(")");
		}
	}
	
}
