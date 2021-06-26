/**
 * @author AJWuu
 */

package minimumSpanningTrees;

import java.util.Arrays;

public class KruskalAlgorithm {
	
	/*
	 * Kruskal's algorithm sorts all the edges from low weight to high, 
	 * and keeps adding the lowest edges, 
	 * while ignoring those edges that create a cycle.
	 */

	public static void Kruskal(ListMST mst) {
		Edge[] result = new Edge[mst.V];
		int E = 0;
		for (int i=0; i<mst.V; i++) {
			result[i] = new Edge(0, 0, 0.0);
		}
		
		//sort
		Arrays.sort(mst.edges);
		subset[] sets = new subset[mst.V];
		for (int i=0; i<mst.V; i++) {
			sets[i] = new subset();
		}
		for (int j=0; j<mst.V; j++) {
			sets[j].parent = j;
			sets[j].rank = 0;
		}
		
		int key = 0;
		while (E < mst.V-1) {
			Edge next = mst.edges[key++];
			int x = Find.find(sets, next.begin);
			int y = Find.find(sets, next.end);
			if (x != y) {
				result[E++] = next;
				Union.union(sets, x, y);
			}
		}
		
		//output
		double sum = 0;
		System.out.println("Here are the MST edges using Kruskal's Algorithm:");
		for (int i=0; i<E; i++) {
			sum += result[i].weight;
			System.out.println(result[i].begin + " -> " + result[i].end + ": " + result[i].weight);
		}
		System.out.println("Their minimum cost is " + sum);
	}
	
}
