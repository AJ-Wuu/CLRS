/**
 * @author AJWuu
 */

package directedGraph;

import java.util.LinkedList;

public class ShortestPath {

	static int empty = Integer.MAX_VALUE;
	static double INF = 1000.0;

	private static double pathHelper(AdjacentList list, int start, int end, boolean[] visited, LinkedList<Integer> paths, int[] shortestPath, double tempCost, double cost) {
		if (start == end) {
			if (cost > tempCost) {
				cost = tempCost;
				for (int i=0; i<list.vertex; i++) {
					if (i < paths.size()) {
						shortestPath[i] = paths.get(i);
					}
					else {
						shortestPath[i] = empty;
					}
				}
			}
			return cost;
		}

		visited[start] = true;
		for (int i=0; i<list.adj[start].size(); i++) {
			Edge temp = list.adj[start].get(i);
			if (!visited[temp.To]) {
				paths.add(temp.To);
				tempCost += temp.weight;
				cost = pathHelper(list, temp.To, end, visited, paths, shortestPath, tempCost, cost);
				paths.removeLast();
				tempCost -= temp.weight;
			}
		}
		visited[start] = false;
		return cost;
	}

	public static void findShortest(AdjacentList list, int start, int end) {
		boolean[] visited = new boolean[list.vertex];
		LinkedList<Integer> paths = new LinkedList<Integer>();
		paths.add(start);
		int[] shortestPath = new int[list.vertex];
		double tempCost = 0.0, cost = INF;
		cost = pathHelper(list, start, end, visited, paths, shortestPath, tempCost, cost);
		
		System.out.print("The Shortest Path is:");
		for (int i=0; i<shortestPath.length; i++) {
			if (shortestPath[i] != empty) {
				System.out.print(" " + shortestPath[i]);
			}
		}
		System.out.print(" with the cost of " + cost);
	}

}
