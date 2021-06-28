/**
 * @author AJWuu
 */

package directedGraph;

public class Output {

	public static void print(int[][] distance) {
		System.out.println("The shortest distance matrix:");
		for (int i=0; i<distance.length; i++) {
			for (int j=0; j<distance.length; j++) {
				if (distance[i][j] == Integer.MAX_VALUE) {
					System.out.print("INF\t");
				}
				else {
					System.out.print(distance[i][j] + "\t");
				}
			}
			System.out.println();
		}
	}
	
}
