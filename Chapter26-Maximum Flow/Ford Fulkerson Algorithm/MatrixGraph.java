/**
 * @author AJWuu
 */

package fordFulkersonAlgorithm;

public class MatrixGraph {
	int V;
	int[][] matrix;
	
	public MatrixGraph(int V) {
		this.V = V;
		matrix = new int[V][V];
	}
	
	public void addElement(int src, int dest, int weight) {
		matrix[src][dest] = weight;
	}
}
