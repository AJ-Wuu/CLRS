/**
 * @author AJWuu
 */

package fordFulkersonAlgorithm;

import java.util.LinkedList;

public class BFS {

	public static boolean bfs(MatrixGraph graph, int src, int dest, int parent[]) {
		boolean visited[] = new boolean[graph.V];
		LinkedList<Integer> list = new LinkedList<Integer>();
		list.add(src);
		visited[src] = true;
		parent[src] = -1;
		
		while (!list.isEmpty()) {
			int temp = list.poll();
			for (int i=0; i<graph.V; i++) {
				if (!visited[i] && graph.matrix[temp][i] > 0) {
					//find a connection to sink / dest
					if (i == dest) {
						//no more points in BFS
						parent[i] = temp;
						return true;
					}
					list.add(i);
					parent[i] = temp;
					visited[i] = true;
				}
			}
		}
		
		return false;
	}
	
}
