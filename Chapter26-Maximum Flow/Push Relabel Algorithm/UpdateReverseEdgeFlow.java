/**
 * @author AJWuu
 */

package pushRelabelAlgorithm;

public class UpdateReverseEdgeFlow {

	public static void ReverseFlow(Graph graph, int i, int flow) {
		int u = graph.edges.get(i).dest;
		int v = graph.edges.get(i).src;
		for (int j=0; j<graph.edges.size(); j++) {
			if (graph.edges.get(j).dest==v && graph.edges.get(j).src==u) {
				graph.edges.get(j).flow -= flow;
				return ;
			}
		}
		
		//add reverse edge to the residual graph
		graph.addEdge(u, v, 0, flow);
	}
	
}
