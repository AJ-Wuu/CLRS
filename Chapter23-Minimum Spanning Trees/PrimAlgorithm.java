/**
 * @author AJWuu
 */

package minimumSpanningTrees;

public class PrimAlgorithm {
	
	/*
	 * Prim's algorithm starts from a vertex, 
	 * and keeps adding lowest-weight edges which aren't in the tree, 
	 * until all vertices have been covered.
	 */

	public static void Prim(MatrixMST mst) {
		double INF = Double.MAX_VALUE;
		int num = 0; //number of edges
		boolean[] chosen = new boolean[mst.V];
		
		chosen[0] = true;
		System.out.println("Here are the MST edges using Prim's Algorithm:");
		System.out.println(" Edge : Cumulative Weight");
		while (num < mst.V-1) {
			double min = INF;
			int row = 0;
			int col = 0;
			
			for (int i=0; i<mst.V; i++) {
				if (chosen[i] == true) {
					for (int j=0; j<mst.V; j++) {
						if (!chosen[j] && mst.edges[i][j] != 0.0) {
							//not chosen and has an edge
							if (min > mst.edges[i][j]) {
								min = mst.edges[i][j];
								row = i;
								col = j;
							}
						}
					}
				}
			}
			System.out.println(row + " -> " + col + ": " + mst.edges[row][col]);
			chosen[col] = true;
			num++;
		}
	}
	
}
