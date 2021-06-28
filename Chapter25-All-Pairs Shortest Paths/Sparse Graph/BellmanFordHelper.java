package sparseGraph;

public class BellmanFordHelper {

	private static int[][] reweight(int[][] matrix, int[] distance) {
		int V = matrix.length;
		int[][] result = new int[V][V];
		for (int i=0; i<V; i++) {
			for (int j=0; j<V; j++) {
				if (matrix[i][j] != Integer.MAX_VALUE) {
					result[i][j] = matrix[i][j] + distance[i] - distance[j];
				}
				else {
					result[i][j] = matrix[i][j];
				}
			}
		}
		return result;
	}

	public static int[][] BellmanFord(int[][] matrix, int[] distance) {
		int V = matrix.length;
		for (int i=0; i<matrix.length; i++) {
			for (int j=0; j<matrix.length; j++) {
				if (matrix[i][j] != Integer.MAX_VALUE) { //there is an edge from i to j
					if (distance[j] > distance[i] + matrix[i][j]) {
						distance[j] = distance[i] + matrix[i][j];
					}
				}
			}
		}

		int[][] GG = reweight(matrix, distance);
		for (int i=0; i<V; i++) {
			for (int j=0; j<V; j++) {
				if (GG[i][j] < 0) {
					return null;
				}
			}
		}
		return GG;
	}

}
