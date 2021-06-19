/**
 * @author AJWuu
 */

package proto;

public class Delete {

	public static void delete(protovEB vEB, int key) {
		//base case
		if (vEB.u == 2) {
			if (vEB.cluster[key] != null) {
				vEB.cluster[key] = null;
			}
		}
		else {
			delete(vEB.cluster[vEB.getHigh(key, vEB)], vEB.getLow(key, vEB));
			boolean isInCluster = false;
			for (int i=vEB.getHigh(key, vEB)*vEB.root(vEB.u); i<(vEB.getHigh(key, vEB)+1)*vEB.root(vEB.u); i++) {
				if (Member.isMember(vEB.cluster[vEB.getHigh(key, vEB)], i)) {
					isInCluster = true;
					break;
				}
			}
			//if no member is present, then update summary to 0
			if (isInCluster == false) {
				delete(vEB.summary, vEB.getHigh(key, vEB));
			}
		}
	}
	
}
