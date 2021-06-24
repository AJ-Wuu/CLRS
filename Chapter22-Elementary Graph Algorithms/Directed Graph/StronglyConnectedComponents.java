/**
 * @author AJWuu
 */

package directedGraph;

import java.util.Iterator;
import java.util.Stack;

public class StronglyConnectedComponents {

	static int Time = 0;
	
	private static void SCCHelper(AdjacentList list, int i, int[] visit, int[] low, boolean[] stackMember, Stack<Integer> stack) {
		visit[i] = Time;
		low[i] = Time;
		Time++;
		stackMember[i] = true;
		stack.push(i);
		
		int n;
		Iterator<Edge> iter = list.adj[i].iterator();
		while (iter.hasNext()) {
			n = iter.next().To;
			if (visit[n] == -1) {
				SCCHelper(list, n, visit, low, stackMember, stack);
				low[i] = Math.min(low[i], low[n]);
			}
			else if (stackMember[n]) {
				low[i] = Math.min(low[i], visit[n]);
			}
		}
		
		int w = -1;
		if (low[i] == visit[i]) {
			while (w != i) {
				w = stack.pop();
				System.out.print(w + " ");
				stackMember[w] = false;
			}
			System.out.println();
		}
	}
	
	public static void SCC(AdjacentList list) {
		int V = list.vertex;
		int[] visit = new int[V];
		int[] low = new int[V];
		for (int i=0; i<V; i++) {
			visit[i] = -1;
			low[i] = -1;
		}
		boolean[] stackMember = new boolean[V];
		Stack<Integer> stack = new Stack<Integer>();
		
		//DFS
		for (int i=0; i<V; i++) {
			if (visit[i] == -1) {
				SCCHelper(list, i, visit, low, stackMember, stack);
			}
		}
	}
	
}
