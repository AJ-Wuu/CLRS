/**
 * @author AJWuu
 */

package proto;

public class Insert {

	public static void insert(protovEB vEB, int key) {
		//base case
		if (vEB.u == 2) {
			vEB.cluster[key] = new protovEB(1);
		}
		else {
			insert(vEB.cluster[vEB.getHigh(key, vEB)], vEB.getLow(key, vEB));
			insert(vEB.summary, vEB.getHigh(key, vEB));
		}
	}
	
}
