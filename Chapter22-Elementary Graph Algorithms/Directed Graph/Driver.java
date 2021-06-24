/**
 * @author AJWuu
 */

package directedGraph;

public class Driver {

	public static void main(String[] args) {
		AdjacentList graph1 = new AdjacentList(4);
		graph1.addEdge(0, 1, 1);
		graph1.addEdge(0, 2, 1);
		graph1.addEdge(3, 0, 1);
		graph1.addEdge(2, 1, 1);
		graph1.addEdge(2, 0, 1);
		graph1.addEdge(1, 3, 1);
		System.out.println("All Paths of Graph1");
		AllPaths.printAllPaths(graph1);
		System.out.println("\nTopological Sort of Graph1");
		TopologicalSort.TopoSort(graph1);
				
		System.out.println("\n\nAll Possible Topological Sorts of Graph2:");
		AdjacentList graph2 = new AdjacentList(8);
		graph2.addEdge(0, 6, 1);
		graph2.addEdge(1, 4, 1);
		graph2.addEdge(3, 0, 1);
		graph2.addEdge(5, 1, 1);
		graph2.addEdge(7, 1, 1);
		graph2.addEdge(1, 2, 1);
		graph2.addEdge(1, 6, 1);
		graph2.addEdge(3, 4, 1);
		graph2.addEdge(7, 0, 1);
		TopologicalSort.AllTopoSorts(graph2);
		
		AdjacentList graph3 = new AdjacentList(11);
	    graph3.addEdge(0, 1, 0);
	    graph3.addEdge(0, 3, 0);
	    graph3.addEdge(1, 2, 0);
	    graph3.addEdge(1, 4, 0);
	    graph3.addEdge(2, 0, 0);
	    graph3.addEdge(2, 6, 0);
	    graph3.addEdge(3, 2, 0);
	    graph3.addEdge(4, 5, 0);
	    graph3.addEdge(4, 6, 0);
	    graph3.addEdge(5, 6, 0);
	    graph3.addEdge(5, 7, 0);
	    graph3.addEdge(5, 8, 0);
	    graph3.addEdge(5, 9, 0);
	    graph3.addEdge(6, 4, 0);
	    graph3.addEdge(7, 9, 0);
	    graph3.addEdge(8, 9, 0);
	    graph3.addEdge(9, 8, 0);
		System.out.println("\nStrongly Connected Components of Graph3");
		StronglyConnectedComponents.SCC(graph3);
		
		AdjacentList graph4 = new AdjacentList(4);
		graph4.addEdge(0, 1, 2);
		graph4.addEdge(0, 2, 2);
		graph4.addEdge(1, 2, 1);
		graph4.addEdge(1, 3, 1);
		graph4.addEdge(2, 0, 1);
		graph4.addEdge(2, 3, 2);
		graph4.addEdge(3, 3, 2);
		System.out.println("\nShortest Path of Graph4");
		ShortestPath.findShortest(graph4, 0, 3);
	}

}
