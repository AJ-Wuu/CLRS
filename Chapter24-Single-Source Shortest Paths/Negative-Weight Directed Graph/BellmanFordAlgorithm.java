/**
 * @author AJWuu
 */

package negativeWeightDirectedGraph;

public class BellmanFordAlgorithm {

	public static int INF = Integer.MAX_VALUE;

	public static void BellmanFord(ListGraph graph, int src) {
		int V = graph.V;
		int E = graph.E;
		int[] distance = new int[V];
		String[] path = new String[V];

		//Initialization for the distances between src and other points
		for (int i=0; i<V; i++) {
			distance[i] = INF;
			path[i] = String.valueOf(src);
		}
		distance[src] = 0; //the distance of src to itself should be 0

		//relax
		for (int i=1; i<V; i++) {
			for (int j=0; j<E; j++) {
				int x = graph.edges[j].src;
				int y = graph.edges[j].dest;
				int weight = graph.edges[j].weight;
				if (distance[x] != INF && distance[x] + weight < distance[y]) {
					distance[y] = distance[x] + weight;
					if (!path[y].equals(String.valueOf(x))) {
						path[y] += String.valueOf(x);
					}
				}
			}
		}
		for (int i=0; i<V; i++) { //add dest to path
			if (i != src) {
				path[i] += String.valueOf(i);
			}
		}

		//check negative-weight cycles
		for (int j=0; j<E; j++) {
			int x = graph.edges[j].src;
			int y = graph.edges[j].dest;
			int weight = graph.edges[j].weight;
			if (distance[x] != INF && distance[x] + weight < distance[y]) {
				System.out.println("Graph contains negative-weight cycles");
				return ;
			}
		}

		Output.print(distance, path, V);
	}

}
