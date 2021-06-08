package rodCutting;

public class RodCutting {

	static int max(int a, int b) {
		if (a <= b) {
			return b;
		}
		else {
			return a;
		}
	}

	//top-down with recursion
	static int cutRod(int price[], int length) {
		if (length <= 0) {
			return 0;
		}

		int maxVal = 0; //-INF is also reasonable
		for (int i=0; i<length; i++) {
			maxVal = max(maxVal, price[i] + cutRod(price, length-i-1));
		}
		return maxVal;
	}

	//top-down with memoization
	static int memoizedCutRod(int[] price, int length) {
		int[] memo = new int[length+1]; //special key point: memo.length = length + 1
		for (int i=1; i<=length; i++) {
			memo[i] = -1;
		}
		return memoizedCutRodAux(price, length, memo);
	}

	static int memoizedCutRodAux(int[] price, int length, int[] memo) {
		if (memo[length] >= 0) {
			return memo[length];
		}
		
		int maxVal = -1;
		if (length == 0) {
			maxVal = 0;
		}
		else {
			for (int i=0; i<length; i++) {
				maxVal = max(maxVal, price[i] + memoizedCutRodAux(price, length-i-1, memo));
			}
		}
		memo[length] = maxVal; //update memo for future use
		return maxVal;
	}

	//bottom-up
	static int bottomUpCutRod(int[] price, int length) {
		int[] memo = new int[length+1];
		memo[0] = 0;
		
		int maxVal;
		for (int i=1; i<=length; i++) {
			maxVal = -1;
			for (int j=1; j<=i; j++) {
				maxVal = max(maxVal, price[j-1] + memo[i-j]);
			}
			memo[i] = maxVal;
		}
		return memo[length];
	}
	
	//bottom-up extension
	static void extendedBottomUpCutRod(int[] price, int length) {
		int[] r = new int[length+1];
		int[] s = new int[length+1];
		r[0] = 0;
		
		int maxVal;
		for (int i=1; i<=length; i++) {
			maxVal = -1;
			for (int j=1; j<=i; j++) {
				if (maxVal < price[j-1] + r[i-j]) {
					maxVal = price[j-1] + r[i-j];
					s[i] = j;
				}
			}
			r[i] = maxVal;
		}
		
		while (length > 0) {
			System.out.print(s[length] + " ");
			length = length - s[length];
		}
		System.out.println();
	}

	public static void main(String[] args) {
		int price[] = {1,5,8,9,10,17,17,20,24,30};
		int length = price.length;
		System.out.println("Optimal Decompositions:");
		for (int i=0; i<length; i++) {
			System.out.println("r" + (i+1) + " = " + price[i] + " with optimal: "
								+ "CutRod = " + cutRod(price, i+1) 
								+ "; Memoization = " + memoizedCutRod(price, i+1)
								+ "; BottomUp = " + bottomUpCutRod(price, i+1));
		}
		System.out.println("\nSpliting Conditions:");
		for (int i=1; i<length+1; i++) {
			System.out.print("Rod with length " + i + " would be split into segment(s) with length of ");
			extendedBottomUpCutRod(price, i);
		}
	}

}
