/**
 * @author AJWuu
 */

package vEB;

public class vEB {
	int u; //universe size
	int max;
	int min;
	vEB summary;
	vEB[] cluster;
	
	public int getHigh(int x) {
		return (x / (int)Math.ceil(Math.sqrt(this.u)));
	}
	
	public int getLow(int x) {
		return (x % (int)Math.ceil(Math.sqrt(this.u)));
	}
	
	public int getIndex(int clusterNum, int pos) {
		return (clusterNum * (int)Math.ceil(Math.sqrt(this.u)) + pos);
	}
	
	public vEB(int size) {
		u = size;
		max = Integer.MIN_VALUE;
		min = Integer.MAX_VALUE;
		
		//base case
		if (size <= 2) {
			summary = null;
			cluster = new vEB[0];
		}
		else {
			int num = (int)Math.ceil(Math.sqrt(size));
			summary = new vEB(num);
			cluster = new vEB[num];
			for (int i=0; i<num; i++) {
				cluster[i] = new vEB(num);
			}
		}
	}
	
	public vEB(int u, int max, int min, vEB summary, vEB[] cluster) {
		this.u = u;
		this.max = max;
		this.min = min;
		this.summary = summary;
		this.cluster = cluster;
	}
}
