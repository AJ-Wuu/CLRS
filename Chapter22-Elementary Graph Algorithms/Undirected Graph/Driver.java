/**
 * @author AJWuu
 */

package undirectedGraph;

public class Driver {

	public static void main(String[] args) {
		int V = 6;
		AdjacentList graphList = new AdjacentList(V);
		boolean[] visited = new boolean[V];
		graphList.addEdge(1, 2);
		graphList.addEdge(1, 3);
		graphList.addEdge(2, 4);
		graphList.addEdge(2, 5);
		System.out.println("****Adjacent List****");
		System.out.print("BFS: ");
		BreadthFirstSearch.BFSList(graphList, 1);
		System.out.println();
		System.out.print("DFS: ");
		DepthFirstSearch.DFSList(graphList, 1, visited);
		System.out.println("\n");
		
		AdjacentMatrix graphMatrix = new AdjacentMatrix(V, V);
		graphMatrix.addEdge(1, 2);
		graphMatrix.addEdge(1, 3);
		graphMatrix.addEdge(2, 4);
		graphMatrix.addEdge(2, 5);
		visited = new boolean[V];
		System.out.println("***Adjacent Matrix***");
		System.out.print("BFS: ");
		BreadthFirstSearch.BFSMatrix(graphMatrix, 1);
		System.out.println();
		System.out.print("DFS: ");
		DepthFirstSearch.DFSMatrix(graphMatrix, 1, visited);
	}

}
