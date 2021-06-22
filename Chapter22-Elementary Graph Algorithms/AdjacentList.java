/**
 * @author AJWuu
 */

package graph;

import java.util.LinkedList;

public class AdjacentList {
	int V; //vertex
	LinkedList<Integer>[] adj;
	
	@SuppressWarnings("unchecked")
	public AdjacentList(int V) {
		this.V = V;
		this.adj = new LinkedList[V];
		for (int i=0; i<V; i++) {
			adj[i] = new LinkedList<Integer>();
		}
	}
	
	public int getVertex() {
		return V;
	}
	
	public void addEdge(int V, int E) {
		adj[V].add(E);
	}
}
