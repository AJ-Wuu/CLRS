/**
 * @author AJWuu
 */

package nonNegativeWeightDirectedGraph;

public class TestGraph {

	public static void main(String[] args) {
		MatrixGraph graph = new MatrixGraph(4);
		graph.addElement(0, 1, 1);
		graph.addElement(0, 2, 4);
		graph.addElement(1, 2, 2);
		graph.addElement(1, 3, 6);
		graph.addElement(2, 3, 3);
		DijkstraAlgorithm.Dijkstra(graph, 0);
	}

}
