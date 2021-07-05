/**
 * @author AJWuu
 */

package pushRelabelAlgorithm;

import java.util.LinkedList;

class Vertex {
	int height;
	int excessFlow;
	
	public Vertex(int height, int excessFlow) {
		this.height = height;
		this.excessFlow = excessFlow;
	}
}

class Edge {
	int src;
	int dest;
	int flow; //current flow
	int capacity;
	
	public Edge(int src, int dest, int flow, int capacity) {
		this.src = src;
		this.dest = dest;
		this.flow = flow;
		this.capacity = capacity;
	}
}

public class Graph {
	int V;
	Vertex[] vertices;
	LinkedList<Edge> edges;
	
	public Graph(int V) {
		this.V = V;
		vertices = new Vertex[V];
		for (int i=0; i<V; i++) {
			vertices[i] = new Vertex(0, 0);
		}
		edges = new LinkedList<Edge>();
	}
	
	public void addEdge(int src, int dest, int flow, int capacity) {
		Edge edge = new Edge(src, dest, flow, capacity);
		edges.add(edge);
	}
}
