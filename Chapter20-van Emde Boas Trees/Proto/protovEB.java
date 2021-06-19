/**
 * @author AJWuu
 */

package proto;

public class protovEB {
	int u; //universe size -- number of keys in proto-vEB structure
	protovEB summary; //has size of sqrt(u)
	protovEB[] cluster; //an array of protovEB with size of sqrt(u)
	
	public int root(int u) {
		return (int)(Math.sqrt(u));
	}
	
	public int getHigh(int x, protovEB vEB) {
		return (x / root(vEB.u));
	}
	
	public int getLow(int x, protovEB vEB) {
		return (x % root(vEB.u));
	}
	
	public int getIndex(int clusterNum, int pos, protovEB vEB) {
		return (clusterNum * root(vEB.u) + pos);
	}
	
	public protovEB(int size) {
		this.u = size;
		if (size <= 2) {
			this.summary = null;
			this.cluster = new protovEB[size];
		}
		else {
			this.summary = new protovEB(root(size));
			this.cluster = new protovEB[root(size)];
			for (int i=0; i<root(size); i++) {
				cluster[i] = new protovEB(root(size));
			}
		}
	}
}
