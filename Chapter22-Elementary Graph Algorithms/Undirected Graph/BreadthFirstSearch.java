/**
 * @author AJWuu
 */

package undirectedGraph;

import java.util.Iterator;
import java.util.LinkedList;

public class BreadthFirstSearch {

	public static void BFSList(AdjacentList graph, int key) {
		boolean visited[] = new boolean[graph.getVertex()];
		LinkedList<Integer> bfs = new LinkedList<Integer>();
		visited[key] = true;
		bfs.add(key);
		
		while (bfs.size() != 0) {
			key = bfs.poll(); //dequeue
			System.out.print(key + " ");
			
			//iterator has some great helper functions!!!
			Iterator<Integer> iter = graph.adj[key].iterator();
			while (iter.hasNext()) {
				int n = iter.next();
				if (!visited[n]) { //not visited
					visited[n] = true;
					bfs.add(n);
				}
			}
		}
	}
	
	public static void BFSMatrix(AdjacentMatrix graph, int key) {
		boolean[] visited = new boolean[graph.getEdge()];
		LinkedList<Integer> list = new LinkedList<Integer>();
		list.add(key);
		visited[key] = true;
		
		int temp;
		while (!list.isEmpty()) {
			temp = list.get(0);
			System.out.print(temp + " ");
			list.remove(list.get(0));
			
			for (int i=0; i<graph.getEdge(); i++) {
				if (graph.adj[temp][i] == 1 && !visited[i]) {
					list.add(i);
					visited[i] = true;
				}
			}
		}
	}
	
}
