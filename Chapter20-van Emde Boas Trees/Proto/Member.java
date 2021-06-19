/**
 * @author AJWuu
 */

package proto;

public class Member {

	public static boolean isMember(protovEB vEB, int key) {
		if (key >= vEB.u) {
			return false;
		}
		
		//base case
		if (vEB.u == 2) {
			return (vEB.cluster[key] == null ? false : true);
		}
		else {
			return isMember(vEB.cluster[vEB.getHigh(key, vEB)], vEB.getLow(key, vEB));
		}
	}
	
}
