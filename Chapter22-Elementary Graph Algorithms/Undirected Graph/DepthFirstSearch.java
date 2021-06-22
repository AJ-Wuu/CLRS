/**
 * @author AJWuu
 */

package undirectedGraph;

import java.util.Iterator;

public class DepthFirstSearch {

	public static void DFSList(AdjacentList graph, int key, boolean[] visited) {
		visited[key] = true;
		System.out.print(key + " ");
		
		Iterator<Integer> i = graph.adj[key].iterator();
		while (i.hasNext()) {
			int next = i.next();
			if (!visited[next]) {
				DFSList(graph, next, visited);
			}
		}
	}
	
	public static void DFSMatrix(AdjacentMatrix graph, int key, boolean[] visited) {
		System.out.print(key + " ");
		visited[key] = true;
		for (int i=0; i<graph.getEdge(); i++) {
			if (graph.adj[key][i] == 1 && !visited[i]) {
				DFSMatrix(graph, i, visited);
			}
		}
	}

}
