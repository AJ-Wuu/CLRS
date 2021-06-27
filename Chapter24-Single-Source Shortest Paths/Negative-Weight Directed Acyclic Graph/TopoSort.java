/**
 * @author AJWuu
 */

package negativeWeightDirectedAcyclicGraph;

import java.util.Iterator;
import java.util.Stack;

public class TopoSort {

	public static void Topo(AdjacentList graph, int V, boolean visited[], Stack<Integer> stack) {
		visited[V] = true;
		Iterator<Node> iter = graph.list[V].iterator();
		while (iter.hasNext()) {
			Node node = iter.next();
			if (!visited[node.V]) {
				Topo(graph, node.V, visited, stack);
			}
		}
		stack.push(V);
	}
	
}
