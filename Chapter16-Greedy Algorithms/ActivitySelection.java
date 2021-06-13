/**
 * @author AJWuu
 */

package activitySelection;

public class ActivitySelection {

	static int INT_MAX = Integer.MAX_VALUE;
	static int INT_MIN = Integer.MIN_VALUE;

	static void recursiveSelection(int[] start, int[] end, int i, int j) {
		if (i >= j) {
			return ;
		}

		int a = i+1;
		while (a < j && start[a] < end[i]) { //find the first activity in start[] to finish
			a++;
		}
		if (a < j) {
			output(a);
			recursiveSelection(start, end, a, j);
		}
	}

	static void greedySelection(int[] start, int[] end) {
		int n = start.length;
		int k = 0;
		for (int m=1; m<n; m++) {
			if (start[m] >= end[k]) {
				output(m);
				k = m;
			}
		}
	}

	static void output(int n) {
		System.out.print("A" + n + " ");
	}

	static void dynamicSelector(int[] start, int[] end, int n) {
		int[][] count = new int[n+2][n+2];
		int[][] act = new int[n+2][n+2];

		for (int i=0; i<n+1; i++) {
			count[i][i] = 0;
			count[i][i+1] = 0;
		}
		count[n+1][n+1] = 0;
		int j, k;
		for (int Len=2; Len<=n+1; Len++) {
			for (int i=0; i<=n-Len+1; i++) {
				j = i + Len;
				count[i][j] = 0;
				k = j - 1;
				while (end[i] < end[k]) {
					if (end[i] <= start[k] && end[k] <= start[j]) {
						if (count[i][k] + count[k][j] + 1 > count[i][j]) {
							count[i][j] = count[i][k] + count[k][j] + 1;
							act[i][j] = k;
						}
					}
					k--;
				}
			}
		}
		System.out.println("A maximum size set of mutually compatible activities has size " + count[0][n+1]);
		System.out.print("The set contains: ");
		printActivity(count, act, 0, n+1);
	}

	static void printActivity(int[][] c, int[][] act, int i, int j) {
		if (c[i][j] > 0) {
			int k = act[i][j];
			printActivity(c, act, i, k);
			printActivity(c, act, k, j);
			System.out.print("A" + k + " ");
		}
	}

	public static void main(String[] args) {
		//This program is to select best activities in order.
		//In other words, it doesn't move back and forth, so FIFO.
		//Also, this is not a correct method for getting best activity set within all activities.
		int[] startTime = {0,1,3,0,5,3,5,6,8,8,2,12,INT_MAX};
		int[] endTime = {0,4,5,6,7,9,9,10,11,12,14,16,INT_MIN};
		//The last dummy time is not necessary for recursive and greedy;
		//but it is necessary for dynamic, in case "j" goes out-of-bound;
		recursiveSelection(startTime, endTime, 0, startTime.length);
		System.out.println();
		greedySelection(startTime, endTime);
		System.out.println();
		dynamicSelector(startTime, endTime, startTime.length-2);
	}

}
