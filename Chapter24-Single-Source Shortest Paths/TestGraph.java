/**
 * @author AJWuu
 */

package nonNegativeWeightGraph;

public class TestGraph {

	public static void main(String[] args) {
		int V = 5;
		int E = 8;
		ListGraph graph = new ListGraph(V, E);
		graph.edges[0] = new Edge(0, 1, -1);
		graph.edges[1] = new Edge(0, 2, 4);
		graph.edges[2] = new Edge(1, 2, 3);
		graph.edges[3] = new Edge(1, 3, 2);
		graph.edges[4] = new Edge(1, 4, 2);
		graph.edges[5] = new Edge(3, 2, 5);
		graph.edges[6] = new Edge(3, 1, 1);
		graph.edges[7] = new Edge(4, 3, -3);
		BellmanFordAlgorithm.BellmanFord(graph, 0);
	}

}
