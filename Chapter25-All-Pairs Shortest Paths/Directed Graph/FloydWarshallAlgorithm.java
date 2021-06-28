/**
 * @author AJWuu
 */

package directedGraph;

public class FloydWarshallAlgorithm {

	public static void Floyd(MatrixGraph graph) {
		int V = graph.V;
		int[][] distance = new int[V][V];		
		for (int i=0; i<V; i++) {
			for (int j=0; j<V; j++) {
				distance[i][j] = graph.edges[i][j];
			}
		}
		
		for (int k=0; k<V; k++) {
			for (int i=0; i<V; i++) {
				for (int j=0; j<V; j++) {
					int temp = distance[i][k] + distance[k][j];
					if (temp > 0 && temp < distance[i][j]) { //not out-of-bound
						distance[i][j] = temp;
					}
				}
			}
		}
		
		Output.print(distance);
	}
	
}
