/**
 * @author AJWuu
 */

package maximumSubarray;

public class Purchase {
	private int left;
	private int right;
	private double growth;
	
	public Purchase(int left, int right, double growth) {
		this.left = left;
		this.right = right;
		this.growth = growth;
	}
	
	public void setLeft(int left) {
		this.left = left;
	}
	
	public int getLeft() {
		return left;
	}
	
	public void setRight(int right) {
		this.right = right;
	}
	
	public int getRight() {
		return right;
	}
	
	public void setGrowth(double growth) {
		this.growth = growth;
	}
	
	public double getGrowth() {
		return growth;
	}
	
	public String toString() {
		return "From Day" + getLeft() + " to Day" + getRight() + " for " + getGrowth();
	}
}
