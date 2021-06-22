/**
 * @author AJWuu
 */

package graph;

public class AdjacentMatrix {
	int V; //vertex
	int E; //edge
	int[][] adj; //matrix
	
	public AdjacentMatrix(int V, int E) {
		this.V = V;
		this.E = E;
		this.adj = new int[V][E];
	}
	
	public int getEdge() {
		return E;
	}
	
	public void addEdge(int V, int E) {
		adj[V][E] = 1;
		adj[E][V] = 1;
	}
}
