/**
 * @author AJWuu
 */

package proto;

public class Compare {

	public static int minimum(protovEB vEB) {
		if (vEB.u == 2) {
			if (vEB.cluster[0] != null) {
				return 0;
			}
			else if (vEB.cluster[1] != null) {
				return 1;
			}
			else {
				return -1;
			}
		}
		else {
			int minCluster = minimum(vEB.summary);
			int offset;
			if (minCluster == -1) {
				return -1;
			}
			else {
				offset = minimum(vEB.cluster[minCluster]);
				return vEB.getIndex(minCluster, offset, vEB);
			}
		}
	}

	public static int maximum(protovEB vEB) {
		if (vEB.u == 2) {
			if (vEB.cluster[1] != null) {
				return 1;
			}
			else if (vEB.cluster[0] != null) {
				return 0;
			}
			else {
				return -1;
			}
		}
		else {
			int maxCluster = maximum(vEB.summary);
			int offset;
			if (maxCluster == -1) {
				return -1;
			}
			else {
				offset = maximum(vEB.cluster[maxCluster]);
				return vEB.getIndex(maxCluster, offset, vEB);
			}
		}
	}

}
