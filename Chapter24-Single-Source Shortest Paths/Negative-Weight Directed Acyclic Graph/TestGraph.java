/**
 * @author AJWuu
 */

package negativeWeightDirectedAcyclicGraph;

public class TestGraph {

	public static void main(String[] args) {
		AdjacentList graph = new AdjacentList(6);
		graph.addEdge(0, 1, 5);
		graph.addEdge(0, 2, 3);
		graph.addEdge(1, 3, 6);
		graph.addEdge(1, 2, 2);
		graph.addEdge(2, 4, 4);
		graph.addEdge(2, 5, 2);
		graph.addEdge(2, 3, 7);
		graph.addEdge(3, 4, -1);
		graph.addEdge(4, 5, -2);
		DAGAlgorithm.DAG(graph, 1);
	}

}
