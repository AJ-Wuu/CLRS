/**
 * @author AJWuu
 */

package multithread;

public class EvenNumber extends Thread {

	@Override
	public void run() {
		System.out.println("Start EvenNumber Thread");
		for (int i=0; i<5; i++) {
			System.out.println("EvenNumber is: " + 2*i);
		}
		System.out.println("End EvenNumber Thread");
	}
	
}
