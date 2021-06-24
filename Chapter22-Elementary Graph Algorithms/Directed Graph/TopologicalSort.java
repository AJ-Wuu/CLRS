/**
 * @author AJWuu
 */

package directedGraph;

import java.util.Iterator;
import java.util.Stack;

public class TopologicalSort {

	private static void TopoHelper(AdjacentList list, int i, boolean[] visited, Stack<Integer> stack) {
		visited[i] = true;
		Iterator<Edge> iter = list.adj[i].iterator();
		while (iter.hasNext()) {
			int temp = iter.next().To;
			if (!visited[temp]) {
				TopoHelper(list, temp, visited, stack);
			}
		}
		stack.push(i);
	}

	public static void TopoSort(AdjacentList list) {
		Stack<Integer> stack = new Stack<Integer>();
		boolean visited[] = new boolean[list.vertex];
		for (int i=0; i<list.vertex; i++) {
			if (!visited[i]) {
				TopoHelper(list, i, visited, stack);
			}
		}

		//output
		while (!stack.empty()) {
			System.out.print(stack.pop() + " ");
		}
	}

	private static void AllSortsHelper(AdjacentList list, boolean[] visited, int[] degree, Stack<Integer> stack) {
		for (int i=0; i<list.vertex; i++) {
			if (!visited[i] && degree[i] == 0) {
				visited[i] = true;
				stack.add(i);
				for (int j=0; j<list.adj[i].size(); j++) {
					degree[list.adj[i].get(j).To]++;
				}
				AllSortsHelper(list, visited, degree, stack);

				visited[i] = false;
				stack.pop();
				for (int j=0; j<list.adj[i].size(); j++) {
					degree[list.adj[i].get(j).To]--;
				}
			}
		}

		//output		
		if (stack.size() == list.vertex) {
			System.out.print(stack);
			System.out.println();
		}
	}

	public static void AllTopoSorts(AdjacentList list) {
		boolean[] visited = new boolean[list.vertex];
		int[] degree = new int[list.vertex];
		Stack<Integer> stack = new Stack<Integer>();
		AllSortsHelper(list, visited, degree, stack);
	}

}
