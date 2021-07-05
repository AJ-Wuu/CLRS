/**
 * @author AJWuu
 */

package pushRelabelAlgorithm;

public class Push {

	public static boolean push(Graph graph, int src) {
		for (int i=0; i<graph.edges.size(); i++) {
			if (graph.edges.get(i).src == src) {
				if (graph.edges.get(i).flow == graph.edges.get(i).capacity) {
					//no push is possible
					continue;
				}
				if (graph.vertices[src].height > graph.vertices[graph.edges.get(i).dest].height) {
					int flow = Math.min(graph.edges.get(i).capacity - graph.edges.get(i).flow, graph.vertices[src].excessFlow);
					graph.vertices[src].excessFlow -= flow;
					graph.vertices[graph.edges.get(i).dest].excessFlow += flow;
					graph.edges.get(i).flow += flow;
					UpdateReverseEdgeFlow.ReverseFlow(graph, i, flow);
					return true;
				}
			}
		}
		return false;
	}
	
}
