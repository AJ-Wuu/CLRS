/**
 * @author AJWuu
 */

package minimumSpanningTrees;

class subset {
	int parent;
	int rank;
}

public class Find {
	
	//find root
	public static int find(subset[] sets, int i) {
		if (sets[i].parent != i) {
			sets[i].parent = find(sets, sets[i].parent);
		}
		return sets[i].parent;
	}
	
}
