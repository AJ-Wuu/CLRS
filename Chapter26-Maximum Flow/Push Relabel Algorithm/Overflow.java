/**
 * @author AJWuu
 */

package pushRelabelAlgorithm;

public class Overflow {

	public static int overflow(Graph graph) {
		for (int i=1; i<graph.vertices.length-1; i++) {
			if (graph.vertices[i].excessFlow > 0) {
				return i;
			}
		}
		return -1; //no overflowing vertex
	}
	
}
