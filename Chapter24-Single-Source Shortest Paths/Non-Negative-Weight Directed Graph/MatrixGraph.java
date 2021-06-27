/**
 * @author AJWuu
 */

package nonNegativeWeightDirectedGraph;

public class MatrixGraph {
	int V;
	int[][] weights;
	
	public MatrixGraph(int V) {
		this.V = V;
		weights = new int[V][V];
		for (int i=0; i<V; i++) {
			for (int j=0; j<V; j++) {
				weights[i][j] = Integer.MAX_VALUE;
			}
		}
	}
	
	public void addElement(int src, int dest, int weight) {
		weights[src][dest] = weight;
	}
}
