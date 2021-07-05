/**
 * @author AJWuu
 */

package pushRelabelAlgorithm;

public class MaxFlow {

	public static int getMaxFlow(Graph graph, int src, int dest) {
		Preflow.preflow(graph, src);
		while (Overflow.overflow(graph) != -1) {
			int u = Overflow.overflow(graph);
			if (!Push.push(graph, u)) {
				Relabel.relabel(graph, u);
			}
		}
		//last vertex's excessFlow is the final maximum flow
		return graph.vertices[graph.vertices.length-1].excessFlow;
	}
	
}
