/**
 * @author AJWuu
 */

package pushRelabelAlgorithm;

public class Preflow {

	public static void preflow(Graph graph, int src) {
		graph.vertices[src].height = graph.vertices.length; //src's height = vertices.length
		for (int i=0; i<graph.edges.size(); i++) {
			if (graph.edges.get(i).src == src) { //start from src
				graph.edges.get(i).flow = graph.edges.get(i).capacity;
				graph.vertices[graph.edges.get(i).dest].excessFlow += graph.edges.get(i).flow;
				graph.addEdge(graph.edges.get(i).dest, src, -graph.edges.get(i).flow, 0);
			}
		}
	}
	
}
