/**
 * @author AJWuu
 */

package negativeWeightDirectedGraph;

class Edge {
	int src;
	int dest;
	int weight;
	
	public Edge() {
		this.src = -1;
		this.dest = -1;
		this.weight = Integer.MAX_VALUE;
	}
	
	public Edge(int src, int dest, int weight) {
		this.src = src;
		this.dest = dest;
		this.weight = weight;
	}
}

public class ListGraph {
	int V;
	int E;
	Edge[] edges;
	
	public ListGraph(int V, int E) {
		this.V = V;
		this.E = E;
		edges = new Edge[E];
		for (int i=0; i<E; i++) {
			edges[i] = new Edge();
		}
	}
}
