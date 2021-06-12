/**
 * @author AJWuu
 */

package activitySelection;

public class ActivitySelection {

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

	//???
	static void dynamicSelector(int[] start, int[] end, int n) {
		int[][] c = new int[n+2][n+2];
		int[][] act = new int[n+2][n+2];

        for (int i=0; i<=n+1; i++) {
            for (int j=n+1; j>=i; j--) {
                c[i][j] = 0;
            }
        }

        int maxTemp = 0;
        for (int j=1; j<=n+1; j++) {
            for (int i=0; i<j; i++) {
                for (int k=i+1; k<j; k++) {
                    if (start[k] >= end[i] && end[k] <= start[j]) {
                        if(c[i][k] + c[k][j] + 1 > maxTemp) {
                            maxTemp = c[i][k] + c[k][j] + 1;
                        }
                    }
                }
                c[i][j] = maxTemp;
                maxTemp = 0;
            }
        }
		printActivity(c, act, 0, n+1);
	}

	static void printActivity(int[][] c, int[][] act, int i, int j) {
		if (c[i][j] > 0) {
			int k = act[i][j];
			System.out.print("A" + k + " ");
			printActivity(c, act, i, k);
			printActivity(c, act, k, j);
		}
	}

	public static void main(String[] args) {
		//This program is to select best activities in order.
		//In other words, it doesn't move back and forth, so FIFO.
		//Also, this is not a correct method for getting best activity set within all activities.
		int[] startTime = {-1,1,3,0,5,3,5,6,8,8,2,12};
		int[] endTime = {-1,4,5,6,7,8,9,10,11,12,13,14};
		recursiveSelection(startTime, endTime, 0, startTime.length);
		System.out.println();
		greedySelection(startTime, endTime);
		System.out.println();
		dynamicSelector(startTime, endTime, startTime.length);
	}

}
