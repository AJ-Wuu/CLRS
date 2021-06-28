/**
 * @author AJWuu
 */

package sparseGraph;

public class Output {
	
	public static void print(int[][] path) {
		for (int i=0; i<path.length-1; i++) {
			System.out.print(i + "\t");
			for (int j=0; j<path.length-1; j++) {
				System.out.print(path[i][j] + "\t");
			}
			System.out.println();
		}
	}

}
