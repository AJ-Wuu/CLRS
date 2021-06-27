/**
 * @author AJWuu
 */

package negativeWeightDirectedAcyclicGraph;

import java.util.LinkedList;

class Node {
	int V;
	int weight;
	
	public Node(int V, int weight) {
		this.V = V;
		 this.weight = weight;
	}
}

public class AdjacentList {
	int V;
	LinkedList<Node> list[];
	
	@SuppressWarnings("unchecked")
	public AdjacentList(int V) {
		this.V = V;
		list = new LinkedList[V];
		for (int i=0; i<V; i++) {
			list[i] = new LinkedList<Node>();
		}
	}
	
	public void addEdge(int src, int dest, int weight) {
		Node edge = new Node(dest, weight);
		list[src].add(edge);
	}
}
