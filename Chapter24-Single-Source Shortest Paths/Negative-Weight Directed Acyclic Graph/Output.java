/**
 * @author AJWuu
 */

package negativeWeightDirectedAcyclicGraph;

public class Output {

	public static void print(int[] distance, String[] path, int V, int src) {
		System.out.println("The shortest distances from source " + src + " are:");
		for (int i=0; i<V; i++) {
			if (distance[i] == Integer.MAX_VALUE) {
				System.out.println(i + ": INF");
			}
			else {
				System.out.println(i + ": " + distance[i] + "\t with path: " + path[i]);
			}
		}
	}
	
}
