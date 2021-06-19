/**
 * @author AJWuu
 */

package proto;

public class Predecessor {

	public static int predecessor(protovEB vEB, int key) {
		if (vEB.u == 2) {
			if (key == 1 && vEB.cluster[0] != null) {
				return 0;
			}
			else {
				return -1;
			}
		}
		else {
			//check if there is any key smaller than the target key in cluster
			int offset = predecessor(vEB.cluster[vEB.getHigh(key, vEB)], vEB.getLow(key, vEB));
			if (offset != -1) {
				return vEB.getIndex(vEB.getHigh(key, vEB), offset, vEB);
			}
			else {
				int preCluster = predecessor(vEB.summary, vEB.getHigh(key, vEB));
				if (preCluster == -1) {
					return -1;
				}
				else {
					offset = Compare.maximum(vEB.cluster[preCluster]);
					return vEB.getIndex(preCluster, offset, vEB);
				}
			}
		}
	}
	
}
