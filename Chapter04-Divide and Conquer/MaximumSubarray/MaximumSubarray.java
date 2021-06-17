/**
 * @author AJWuu
 */

package maximumSubarray;

public class MaximumSubarray {

	//Brute Force
	public static Purchase bruteForce(double[] initialArray, int size) {
		Purchase finalPurchase = new Purchase(0, 0, 0.0);
		double difference = 0, temp = 0;
		int begin = 0, end = 0;
		for (int i=0; i<size-1; i++) {
			for (int j=i+1; j<size; j++) {
				temp = initialArray[j] - initialArray[i];
				if (temp > difference) {
					difference = temp;
					begin = i;
					end = j;
				}
			}
		}
		finalPurchase.setLeft(begin);
		finalPurchase.setRight(end);
		finalPurchase.setGrowth(difference);
		return finalPurchase;
	}

	//Divide and Conquer
	static Purchase leftPurchase = new Purchase(0, 0, 0.0);
	static Purchase rightPurchase = new Purchase(0, 0, 0.0);
	static Purchase midPurchase = new Purchase(0, 0, 0.0);
	static Purchase finalPurchase = new Purchase(0, 0, 0.0);

	public static Purchase binaryConquer(double[] diffArray, int begin, int end) {
		if (end-begin == 0) {
			finalPurchase.setLeft(begin);
			finalPurchase.setRight(end+1);
			finalPurchase.setGrowth(diffArray[begin]);
			return finalPurchase;
		}
		else {
			int left = begin, right = end;
			int mid = begin + (end-begin)/2;

			Purchase leftPurchase = binaryConquer(diffArray, left, mid);
			Purchase rightPurchase = binaryConquer(diffArray, mid+1, right);
			Purchase crossList = cross(diffArray, left, mid, right);

			if (leftPurchase.getGrowth() > rightPurchase.getGrowth() && leftPurchase.getGrowth() > crossList.getGrowth()) {
				return leftPurchase;
			}
			else if (rightPurchase.getGrowth()> leftPurchase.getGrowth() && rightPurchase.getGrowth() > crossList.getGrowth()) {
				return rightPurchase;
			}
			else {
				return crossList;
			}
		}
	}

	private static Purchase cross(double[] array, int left, int mid, int right) {
		double leftSum = 0, tempSum = 0;
		int begin = 0;
		for (int p=mid; p>=left; p--) {
			tempSum = tempSum + array[p];
			if (tempSum > leftSum) {
				leftSum = tempSum;
				begin = p;
			}
		}

		double rightSum = 0;
		tempSum = 0;
		int end = 0;
		for (int q=mid+1; q<right; q++) {
			tempSum = tempSum + array[q];
			if (tempSum > rightSum) {
				rightSum = tempSum;
				end = q;
			}
		}

		midPurchase.setLeft(begin);
		midPurchase.setRight(end+1);
		midPurchase.setGrowth(leftSum + rightSum);
		return midPurchase;
	}

	public static void main(String[] args) {
		double[] stock = {100, 113, 110, 85, 105, 102, 86, 63, 81, 101, 94, 106, 101, 79, 94, 90, 97};
		int size = stock.length;
		Purchase result = new Purchase(0, 0, 0.0);
		if (size < 37) { //37 is got from "experience"
			result = bruteForce(stock, size);
		}
		else {
			double[] stockDifference = new double[size-1];
			for (int m=0; m<size-1; m++) {
				stockDifference[m] = stock[m+1] - stock[m];
			}
			result = binaryConquer(stockDifference, 0, size-2);
		}
		System.out.println(result.toString());
	}

}
