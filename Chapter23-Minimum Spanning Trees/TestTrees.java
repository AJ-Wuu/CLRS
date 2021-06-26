/**
 * @author AJWuu
 */

package minimumSpanningTrees;

public class TestTrees {

	public static void main(String[] args) {
		int V = 6;
		int E = 8;
		ListMST list = new ListMST(V, E);
		list.edges[0] = new Edge(0, 1, 4.0);
		list.edges[1] = new Edge(0, 2, 4.0);
		list.edges[2] = new Edge(1, 2, 2.0);
		list.edges[3] = new Edge(2, 3, 3.0);
		list.edges[4] = new Edge(2, 5, 2.0);
		list.edges[5] = new Edge(2, 4, 4.0);
		list.edges[6] = new Edge(3, 4, 3.0);
		list.edges[7] = new Edge(5, 4, 3.0);
		KruskalAlgorithm.Kruskal(list);
		
		V = 5;
		double[][] elements = {{0,9,75,0,0},
								{9,0,95,19,42},
								{75,95,0,51,66},
								{0,19,51,0,31},
								{0,42,66,31,0}};
		MatrixMST matrix = new MatrixMST(V, elements);
		System.out.println();
		PrimAlgorithm.Prim(matrix);
	}

}
