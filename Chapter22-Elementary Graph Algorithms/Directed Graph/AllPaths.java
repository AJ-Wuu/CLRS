/**
 * @author AJWuu
 */

package directedGraph;

import java.util.LinkedList;

public class AllPaths {
	
	private static void pathHelper(AdjacentList list, int start, int end, boolean[] visited, LinkedList<Integer> paths) {
		if (start == end) {
			System.out.println(paths);
			return ;
		}
		
		visited[start] = true;
		for (int i=0; i<list.adj[start].size(); i++) {
			int temp = list.adj[start].get(i).To; //Pay Attention To LinkedList's Inserted Helper Functions
			if (!visited[temp]) {
				paths.add(temp);
				pathHelper(list, temp, end, visited, paths);
				paths.removeLast();
			}
		}
		visited[start] = false;
	}
	
	public static void printAllPathsFromAToB(AdjacentList list, int start, int end) {
		boolean[] visited = new boolean[list.vertex];
		LinkedList<Integer> paths = new LinkedList<Integer>();
		paths.add(start);
		pathHelper(list, start, end, visited, paths);
	}
	
	public static void printAllPaths(AdjacentList list) {
		for (int i=0; i<list.vertex; i++) {
			for (int j=i+1; j<list.vertex; j++) {
				printAllPathsFromAToB(list, i, j);
			}
		}
	}
	
}
