/**
 * @author AJWuu
 */

package sparseGraph;

public class TestGraph {

	public static void main(String[] args) {
		MatrixGraph graph = new MatrixGraph(6);
		graph.append(0, 1, -2);
		graph.append(1, 2, -1);
		graph.append(2, 0, 4);
		graph.append(2, 3, 2);
		graph.append(2, 4, -3);
		graph.append(5, 3, 1);
		graph.append(5, 4, -4);
		JohnsonAlgorithm.Johnson(graph);
	}

}
