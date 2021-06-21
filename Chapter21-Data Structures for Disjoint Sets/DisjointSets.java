/**
 * @author AJWuu
 */

package disjointSets;

class set {
	int n;
	int[] parent; //parent[i] is the unique representative of each set
	int[] rank; //rank[i] is the height of the tree representing the set
	//rank[] is used to compress the height of the trees

	public set(int size) {
		this.n = size;
		this.parent = new int[n];
		for (int i=0; i<size; i++) { //make set
			//the i'th element of the array is the parent of the i'th item
			this.parent[i] = i;
		}
		this.rank = new int[n];
	}
}

public class DisjointSets {

	public static int find(set s, int x) {
		if (s.parent[x] != x) {
			s.parent[x] = find(s, s.parent[x]); //cache the result
		}
		return s.parent[x];
	}

	public static void union(set s, int x, int y) {
		int rep_x = find(s, x);
		int rep_y = find(s, y);
		if (rep_x == rep_y) { //in the same set
			return ;
		}

		if (s.rank[rep_x] < s.rank[rep_y]) {
			s.parent[rep_x] = rep_y; //move x under y
		}
		else { //s.rank[rep_x] >= s.rank[rep_y]
			s.parent[rep_y] = rep_x; //move y under x -> this order doesn't matter for "=="
			if (s.rank[rep_x] == s.rank[rep_y]) {
				//combine two trees, the result tree's rank needs to go up by 1
				s.rank[rep_x]++;
			}
		}
	}

	public static void main(String[] args) {
		int n = 5;
		set s = new set(n);
		union(s, 0, 2);
		union(s, 4, 2);
		union(s, 3, 1);
		
		if (find(s, 4) == find(s, 0)) {
			System.out.println("4 is a friend of 0");
		}
		else {
			System.out.println("4 is not a friend of 0");
		}

		if (find(s, 1) == find(s, 2)) {
			System.out.println("1 is a friend of 2");
		}
		else {
			System.out.println("1 is not a friend of 2");
		}
		
		union(s, 2, 1);
		if (find(s, 3) == find(s, 4)) {
			System.out.println("3 is a friend of 4");
		}
		else {
			System.out.println("3 is not a friend of 4");
		}
	}

}
