/**
 * @author AJWuu
 */

package proto;

public class Successor {

	public static int successor(protovEB vEB, int key) {
		if (vEB.u == 2) {
			if (key == 0 && vEB.cluster[1] != null) {
				return 1;
			}
			else {
				return -1;
			}
		}
		else {
			//check if there is any key greater than the target key in cluster
			int offset = successor(vEB.cluster[vEB.getHigh(key, vEB)], vEB.getLow(key, vEB));
			if (offset != -1) {
				return vEB.getIndex(vEB.getHigh(key, vEB), offset, vEB);
			}
			else {
				int sucCluster = successor(vEB.summary, vEB.getHigh(key, vEB));
				if (sucCluster == -1) {
					return -1;
				}
				else {
					offset = Compare.minimum(vEB.cluster[sucCluster]);
					return vEB.getIndex(sucCluster, offset, vEB);
				}
			}
		}
	}
	
}
