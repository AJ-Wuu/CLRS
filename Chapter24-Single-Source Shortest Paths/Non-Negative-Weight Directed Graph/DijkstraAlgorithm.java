/**
 * @author AJWuu
 */

package nonNegativeWeightDirectedGraph;

import java.util.HashSet;

public class DijkstraAlgorithm {

	public static void Dijkstra(MatrixGraph graph, int src) {
		int V = graph.V;
		int[] distance = new int[V];
		boolean[] visited = new boolean[V];
		for (int i=0; i<V; i++) {
			distance[i] = Integer.MAX_VALUE;
		}
		distance[src] = 0;
		
		int current = src;
		HashSet<Integer> set = new HashSet<Integer>();
		while (true) {
			visited[current] = true;
			for (int i=0; i<V; i++) {
				if (visited[i]) {
					continue;
				}
				set.add(i);
				int alter = distance[current] + graph.weights[current][i];
				if (alter < distance[i]) {
					distance[i] = alter;
				}
			}
			set.remove(current);
			
			if (set.isEmpty()) {
				break;
			}
			
			int min = Integer.MAX_VALUE;
			int index = 0;
			for (int i : set) {
				if (distance[i] < min) {
					min = distance[i];
					index = i;
				}
			}
			current = index;
		}
		
		Output.print(distance, src);
	}
	
}
