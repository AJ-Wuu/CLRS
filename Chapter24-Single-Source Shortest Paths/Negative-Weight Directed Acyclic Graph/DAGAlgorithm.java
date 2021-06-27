/**
 * @author AJWuu
 */

package negativeWeightDirectedAcyclicGraph;

import java.util.Iterator;
import java.util.Stack;

public class DAGAlgorithm {

	public static int INF = Integer.MAX_VALUE;
	
	public static void DAG(AdjacentList graph, int src) {
		//Initialize
		int[] distance = new int[graph.V];
		String[] path = new String[graph.V];
		for (int i=0; i<graph.V; i++) {
			distance[i] = INF;
			path[i] = String.valueOf(src);
		}
		distance[src] = 0;
		
		//Store topological sort
		Stack<Integer> stack = new Stack<Integer>();
		boolean[] visited = new boolean[graph.V];
		for (int i=0; i<graph.V; i++) {
			if (!visited[i]) {
				TopoSort.Topo(graph, i, visited, stack);
			}
		}
		
		//Process in topological order
		while (!stack.isEmpty()) {
			int x = stack.pop(); //the next vertex
			Iterator<Node> iter;
			if (distance[x] != INF) {
				iter = graph.list[x].iterator();
				while (iter.hasNext()) {
					Node temp = iter.next();
					if (distance[temp.V] > distance[x] + temp.weight) {
						distance[temp.V] = distance[x] + temp.weight;
						if (!path[temp.V].equals(String.valueOf(x))) {
							path[temp.V] += String.valueOf(x);
						}
					}
				}
			}
		}
		
		//Add dest to path
		for (int i=0; i<graph.V; i++) {
			if (i != src) {
				path[i] += String.valueOf(i);
			}
		}
		
		//Output
		Output.print(distance, path, graph.V, src);
	}
	
}
