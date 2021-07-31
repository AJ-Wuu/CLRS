//A Graph Theory, known as Eulerian Path / Circuit algorithm / Hierholzer's algorithm
//Time Complexity: O(E)
//Step 1: Find an Eulerian path is determining, if there exists and Eulerian path
//      1.1. Count the in/out degrees of each node by looping through all the edges -> make a int[N][3] with degree[n][0] = Node.index, degree[n][1] = in, degree[n][2] = out
//      1.2. Verify that
//           1.2.1. no node has too many in-/out-going edges (abs(in - out) > 1)
//           1.2.2. sum(in) = sum(out)
//Step 2: Find a valid starting node
//      2.1. If we can find that Node A is the only node with exactly one extra out-going edge, then Node A is the start node (in[A] - out[A] = 1)
//           If we can find that Node B is the only node with exactly one extra in-going edge, then Node B is the end node (out[B] = in[B] = 1)
//      2.2. If all in and out degrees are equal, then the graph is an Euleran Circuit Case, so any node with non-zero degree could be the start node
//Step 3: Modify the DFS to force it to traverse all the edges
//      Trick here -> once we get stuck (that the current node has no unvisited outgoing edges), we BACKTRACK and add the current node to the solution
//                    when backtracking, if the current node has any remaining unvisited edges, we follow any of them calling the DFS recursively to extend the Eulerian path
//                    we can use the out[] array as the signal to see if unvisited node exists -> every time an edge is taken, reduce its outgoing edge count
