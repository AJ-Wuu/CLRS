/**
 * @author AJWuu
 */

package minimumSpanningTrees;

//undirected graph
class Edge implements Comparable<Edge> {
	int begin;
	int end;
	double weight;
	
	public Edge(int begin, int end, double weight) {
		this.begin = begin;
		this.end = end;
		this.weight = weight;
	}
	
	public int compareTo(Edge compareEdge) {
		//this implementation is necessary for Arrays.sort()
		if (this.weight == compareEdge.weight) {
			return 0;
		}
		else if (this.weight > compareEdge.weight) {
			return 1;
		}
		else {
			return -1;
		}
	}
}

public class ListMST {
	int V;
	int E;
	Edge[] edges;
	
	public ListMST(int V, int E) {
		this.V = V;
		this.E = E;
		edges = new Edge[E];
		for (int i=0; i<E; i++) {
			edges[i] = new Edge(0, 0, 0.0);
		}
	}
}
