/**
 * @author AJWuu
 */

package multithread;

public class OddNumber implements Runnable {

	@Override
	public void run() {
		System.out.println("Start OddNumber Thread");
		for (int i=0; i<5; i++) {
			System.out.println("OddNumber is: " + (2*i+1));
			//need parentheses
			//without parentheses, it would be 01, 21, 41, 61, 81
		}
		System.out.println("End OddNumber Thread");
	}
	
}
