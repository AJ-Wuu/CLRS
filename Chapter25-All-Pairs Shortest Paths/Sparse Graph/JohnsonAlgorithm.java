/**
 * @author AJWuu
 */

package sparseGraph;

public class JohnsonAlgorithm {

	public static void Johnson(MatrixGraph graph) {
		int V = graph.V;
		int[] distance = new int[V+1]; //add one vertex for reweight()

		//BellmanFord() makes every edge non-negative
		int[][] GG = BellmanFordHelper.BellmanFord(graph.edges, distance); //non-negative graph.edges
		if (GG == null) {
			System.out.println("Negative Cycle Exists");
		}
		else {
			int[] h = new int[V];
			for (int i=0; i<V; i++) {
				h[i] = distance[i];
			}
			int[][] eachShortest = new int[V][V];
			//Dijkstra() finds the shortest one
			for (int i=0; i<V; i++) {
				eachShortest = DijkstraHelper.Dijkstra(GG, i, eachShortest);
			}
			int[][] allShortest = new int[V][V];
			for (int i=0; i<V; i++) {
				for (int j=0; j<V; j++) {
					if (eachShortest[i][j] != Integer.MAX_VALUE) {
						allShortest[i][j] = eachShortest[i][j] - h[i] + h[j];
					}
				}
			}

			Output.print(allShortest);
		}
	}

}
