//Graph Theory, known as Eulerian Path / Circuit algorithm / Hierholzer's algorithm
//Step 1: Find an Eulerian path is determining, if there exists and Eulerian path
//      1.1. Count the in/out degrees of each node by looping through all the edges -> make a int[N][3] with degree[n][0] = Node.index, degree[n][1] = in, degree[n][2] = out
//      1.2. Verify that
//           1.2.1. no node has too many in-/out-going edges (abs(in - out) > 1)
//           1.2.2. sum(in) = sum(out)
//Step 2: Find a valid starting node
