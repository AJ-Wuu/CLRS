/**
 * @author AJWuu
 */

package fordFulkersonAlgorithm;

public class FordFulkersonAlgorithm {

	public static int FordFulkerson(MatrixGraph graph, int src, int dest) {
		int V = graph.V;
		int[][] tempGraph = graph.matrix;
		int[] parent = new int[V];
		int maxFlow = 0;
		
		//1. See if there is a path from src to dest
		//2. Update parent[]
		while (BFS.bfs(graph, src, dest, parent)) {
			int pathFlow = Integer.MAX_VALUE;
			for (int i=dest; i!=src; i=parent[i]) {
				int j = parent[i];
				pathFlow = Math.min(pathFlow, tempGraph[j][i]); //bottleneck capacity
			}
			for (int i=dest; i!=src; i=parent[i]) { //augment each path and the total
				int j = parent[i];
				tempGraph[j][i] -= pathFlow;
				tempGraph[i][j] += pathFlow;
			}
			maxFlow += pathFlow;
		}
		
		return maxFlow;
	}
	
}
