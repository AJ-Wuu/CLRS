/**
 * @author AJWuu
 */

package directedGraph;

public class TestGraph {

	public static void main(String[] args) {
		MatrixGraph graph = new MatrixGraph(4);
		graph.addElement(0, 1, 5);
		graph.addElement(0, 3, 10);
		graph.addElement(1, 2, 3);
		graph.addElement(2, 3, 1);
		FloydWarshallAlgorithm.Floyd(graph);
	}

}
