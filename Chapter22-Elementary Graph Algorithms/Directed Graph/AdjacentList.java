/**
 * @author AJWuu
 */

package directedGraph;

import java.util.LinkedList;

class Edge {
	int To;
	double weight;
	
	public Edge(int To, double weight) {
		this.To = To;
		this.weight = weight;
	}
}

public class AdjacentList {
	int vertex;
	LinkedList<Edge>[] adj;
	
	@SuppressWarnings("unchecked")
	public AdjacentList(int V) {
		this.vertex = V;
		adj = new LinkedList[V];
		for (int i=0; i<V; i++) {
			adj[i] = new LinkedList<Edge>();
		}
	}
	
	public void addEdge(int From, int To, double weight) {
		Edge e = new Edge(To, weight);
		adj[From].add(e);
	}
}
