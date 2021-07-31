/**
 * @author AJWuu
 */

//A Graph Theory, known as Eulerian Path / Circuit algorithm / Hierholzer's algorithm
//Time Complexity: O(E)
//Step 1: Find an Eulerian path is determining, if there exists and Eulerian path
//      1.1. Count the in/out degrees of each node by looping through all the edges -> make a int[N][3] with degree[n][0] = Node.index, degree[n][1] = in, degree[n][2] = out
//      1.2. Verify that
//           1.2.1. no node has too many in-/out-going edges (abs(in - out) > 1)
//           1.2.2. sum(in) = sum(out)
//Step 2: Find a valid starting node
//      2.1. If we can find that Node A is the only node with exactly one extra out-going edge, then Node A is the start node (out[A] - in[A] = 1)
//           If we can find that Node B is the only node with exactly one extra in-going edge, then Node B is the end node (in[B] - out[B] = 1)
//      2.2. If all in and out degrees are equal, then the graph is an Euleran Circuit Case, so any node with non-zero degree could be the start node
//Step 3: Modify the DFS to force it to traverse all the edges
//      Trick here -> once we get stuck (that the current node has no unvisited outgoing edges), we BACKTRACK and add the current node to the solution
//                    when backtracking, if the current node has any remaining unvisited edges, we follow any of them calling the DFS recursively to extend the Eulerian path
//                    we can use the out[] array as the signal to see if unvisited node exists -> every time an edge is taken, reduce its outgoing edge count

package eulerianPath;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;

class InOut {
	int in;
	int out;
	
	public InOut(int in, int out) {
		this.in = in;
		this.out = out;
	}
}

public class EulerianPath {

	/*
	 * Note: 1. A graph can have multiple Eulerian Paths
	 *       2. This code is for directed graph
	 */
	
	public static ArrayList<Integer> DFS(HashMap<Integer, PriorityQueue<Integer>> graph, int curr, ArrayList<Integer> solution) {
		while (!graph.get(curr).isEmpty()) {
			int next = graph.get(curr).poll();
			DFS(graph, next, solution);
		}
		solution.add(0, curr);
		return solution;
	}
	
	public static ArrayList<Integer> eulerianPath(int[][] nums) {
		//Make graph map
		HashMap<Integer, PriorityQueue<Integer>> graph = new HashMap<Integer, PriorityQueue<Integer>>();
		HashMap<Integer, InOut> degrees = new HashMap<Integer, InOut>();
		int sumIn = 0, sumOut = 0;
		for (int[] num : nums) {
			int src = num[0], dest = num[1];
			graph.computeIfAbsent(src, k -> new PriorityQueue<Integer>());
			graph.get(src).add(dest);
			
			//Create / Update the InOut of each node
			degrees.computeIfAbsent(src, k -> new InOut(0,0));
			degrees.get(src).out++;
			degrees.computeIfAbsent(dest, k -> new InOut(0,0));
			degrees.get(dest).in++;
			sumIn++;
			sumOut++;
		}
		
		//See if Eulerian Path exists
		if (sumIn != sumOut) {
			return (new ArrayList<Integer>());
		}
		int start = 0;
		for (int key : degrees.keySet()) {
			InOut temp = degrees.get(key);
			if (temp.in - temp.out > 1 || temp.out - temp.in > 1) {
				return (new ArrayList<Integer>());
			}
			else if (temp.out - temp.in == 1) { //find the start node
				start = key;
			}
		}
		
		//DFS
		ArrayList<Integer> solution = new ArrayList<Integer>();
		return DFS(graph, start, solution);
	}
	
	public static void main(String[] args) {
		int[][] nums = {{1,2},{1,3},{2,2},{2,4},{2,4},{3,1},{3,2},{3,5},{4,3},{4,6},{5,6},{6,3}};
		ArrayList<Integer> result = eulerianPath(nums);
		for (int i : result) {
			System.out.print(i + " ");
		}
	}

}
