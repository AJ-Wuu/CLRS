/**
 * @author AJWuu
 */

package nonNegativeWeightGraph;

public class Output {

	public static void print(int[] distance, String[] path, int V) {
		System.out.println("Vertex Distance from Source:");
		for (int i=0; i<V; i++) {
			System.out.println(i + ": " + distance[i] + "\twith path: " + path[i]);
		}
	}
	
}
