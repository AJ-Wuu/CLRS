package sparseGraph;

public class DijkstraHelper {

	private static int minDistance(int V, int[] distance, boolean[] visited) {
		int min = Integer.MAX_VALUE;
		int index = -1;
		for (int i=0; i<V; i++) {
			if (!visited[i] && distance[i] <= min) {
				min = distance[i];
				index = i;
			}
		}
		return index;
	}
	
	public static int[][] Dijkstra(int[][] GG, int src, int[][] D) {
		int V = GG.length;
		int[] distance = new int[V];
		boolean[] visited = new boolean[V];
		for (int i=0; i<V; i++) {
			distance[i] = Integer.MAX_VALUE;
		}
		distance[src] = 0;
		
		for (int i=0; i<V-1; i++) {
			int min = minDistance(V, distance, visited);
			visited[min] = true;
			for (int j=0; j<V; j++) {
				if (!visited[j] && GG[min][j] != Integer.MAX_VALUE && distance[min] != Integer.MAX_VALUE && distance[min] + GG[min][j] < distance[j]) {
					distance[j] = distance[min] + GG[min][j];
				}
			}
		}
		
		for (int i=0; i<V; i++) {
			D[src][i] = distance[i];
		}
		return D;
	}

}
