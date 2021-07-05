/**
 * @author AJWuu
 */

package pushRelabelAlgorithm;

public class Relabel {

	public static void relabel(Graph graph, int src) {
		int INF = Integer.MAX_VALUE;
		for (int i=0; i<graph.edges.size(); i++) {
			if (graph.edges.get(i).src == src) {
				if (graph.edges.get(i).flow == graph.edges.get(i).capacity) {
					//no relabeling
					continue;
				}
				if (graph.vertices[graph.edges.get(i).dest].height < INF) {
					INF = graph.vertices[graph.edges.get(i).dest].height;
					graph.vertices[src].height = INF + 1;
				}
			}
		}
	}
	
}
