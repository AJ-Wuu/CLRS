/**
 * @author AJWuu
 */

package minimumSpanningTrees;

public class Union {

	public static void union(subset[] sets, int x, int y) {
		int xRoot = Find.find(sets, x);
		int yRoot = Find.find(sets, y);
		
		if (sets[xRoot].rank < sets[yRoot].rank) {
			sets[xRoot].parent = yRoot;
		}
		else { //sets[xRoot].rank >= sets[yRoot].rank
			sets[yRoot].parent = xRoot;
			if (sets[xRoot].rank == sets[yRoot].rank) {
				sets[xRoot].rank++;
			}
		}
	}
	
}
