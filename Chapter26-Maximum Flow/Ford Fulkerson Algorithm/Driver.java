/**
 * @author AJWuu
 */

package fordFulkersonAlgorithm;

public class Driver {

	public static void main(String[] args) {
		MatrixGraph graph = new MatrixGraph(6);
		graph.addElement(0, 1, 16);
		graph.addElement(0, 2, 13);
		graph.addElement(1, 2, 10);
		graph.addElement(1, 3, 12);
		graph.addElement(2, 1, 4);
		graph.addElement(2, 4, 14);
		graph.addElement(3, 2, 9);
		graph.addElement(3, 5, 20);
		graph.addElement(4, 3, 7);
		graph.addElement(4, 5, 4);
		System.out.println("The maximum flow of the current graph is " + FordFulkersonAlgorithm.FordFulkerson(graph, 0, 5));
	}

}
