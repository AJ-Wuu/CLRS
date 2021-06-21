/**
 * @author AJWuu
 */

package disjointSets;

class set {
	int n;
	char[] parent; //parent[i] is the unique representative of each set
	int[] rank; //rank[i] is the height of the tree representing the set
	//rank[] is used to compress the height of the trees

	public set(int size) {
		this.n = size;
		this.parent = new char[n];
		this.rank = new int[n];
	}
}

public class DisjointSets {

	private static void make(set s, char[] array) {
		for (int i=0; i<array.length; i++) { //make set
			//the i'th element of the array is the parent of the i'th item
			s.parent[i] = array[i];
		}
	}
	
	private static int find(set s, int x, char[] array) {
		int temp = x;
		if (s.parent[x] != array[x]) {
			x = find(s, s.parent[x]-97, array); //find the representative
		}
		s.parent[temp] = array[x]; //cache the result
		return x;
	}

	private static void union(set s, int x, int y, char[] array) {
		int rep_x = find(s, x, array);
		int rep_y = find(s, y, array);
		if (rep_x == rep_y) { //in the same set
			return ;
		}

		if (s.rank[rep_x] > s.rank[rep_y]) {
			s.parent[rep_y] = array[rep_x]; //move y under x
		}
		else { //s.rank[rep_x] <= s.rank[rep_y]
			s.parent[rep_x] = array[rep_y]; //move x under y -> this order doesn't matter for "=="
			if (s.rank[rep_x] == s.rank[rep_y]) {
				//combine two trees, the result tree's rank needs to go up by 1
				s.rank[rep_y]++;
			}
		}
	}

	private static void display(set s, char[] array, int i) {
		System.out.println(array[i] + "'s parent = " + s.parent[i] + ", rank = " + s.rank[i]);
	}
	
	public static void main(String[] args) {
		int n = 8;
		set s = new set(n);
		char[] array = new char[] {'a','b','c','d','e','f','g','h'};
		make(s, array);
		
		System.out.println("******Test union()*******");
		union(s, 0, 1, array); //a -> b
		union(s, 2, 3, array); //c -> d
		union(s, 5, 4, array); //f -> e
		union(s, 7, 6, array); //h -> g
		display(s, array, 1);
		display(s, array, 2);
		
		System.out.println();
		union(s, 0, 2, array); //a -> b -> d <- c
		union(s, 7, 4, array); //f -> e <- g <- h
		display(s, array, 1);
		display(s, array, 3);
		display(s, array, 7);
		display(s, array, 6);
		
		System.out.println();
		union(s, 0, 1, array); //a & b & c -> d
		display(s, array, 0);
		display(s, array, 1);
		
		System.out.println();
		union(s, 2, 7, array); //a & b & c -> d -> e <- f & g & h
		display(s, array, 3);
		display(s, array, 4);
		
		System.out.println("\n*******Test find()*******");
		if (find(s, 7, array) == find(s, 4, array)) {
			System.out.println(array[7] + " is a friend of " + array[4]);
		}
		else {
			System.out.println(array[7] + " is not a friend of " + array[4]);
		}
	}

}
