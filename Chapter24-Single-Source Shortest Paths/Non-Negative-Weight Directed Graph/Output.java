/**
 * @author AJWuu
 */

package nonNegativeWeightDirectedGraph;

public class Output {

	public static void print(int[] distance, int src) {
		for (int i=0; i<distance.length; i++) {
			if (distance[i] == Integer.MAX_VALUE) {
				System.out.println(src + " and " + i + " are not connected");
			}
			else {
				System.out.println("Distance from " + src + " to " + i + " is: " + distance[i]);
			}
		}
	}

}
