/**
 * @author AJWuu
 */

package pushRelabelAlgorithm;

public class Driver {

	public static void main(String[] args) {
		int V = 6;
		Graph graph = new Graph(V);
		graph.addEdge(0, 1, 0, 16);
		graph.addEdge(0, 2, 0, 13);
		graph.addEdge(1, 2, 0, 10);
		graph.addEdge(2, 1, 0, 4);
		graph.addEdge(1, 3, 0, 12);
		graph.addEdge(2, 4, 0, 14);
		graph.addEdge(3, 2, 0, 9);
		graph.addEdge(3, 5, 0, 20);
		graph.addEdge(4, 3, 0, 7);
		graph.addEdge(4, 5, 0, 4);
		System.out.println("The maximum flow of the current graph is " + MaxFlow.getMaxFlow(graph, 0, 5));
	}

}
