/**
 * @author AJWuu
 */

package sparseGraph;

public class MatrixGraph {
	int V;
	int[][] edges;

	public MatrixGraph(int V) {
		this.V = V;
		edges = new int[V][V];
		for (int i=0; i<V; i++) {
			for (int j=0; j<V; j++) {
				edges[i][j] = Integer.MAX_VALUE;
			}
		}
	}

	public void append(int src, int dest, int weight) {
		edges[src][dest] = weight;
	}
}
