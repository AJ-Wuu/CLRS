/**
 * @author AJWuu
 */

package multithread;

public class Test {

	public static void main(String[] args) {
		System.out.println("Start Main Thread");
		
		//Runnable way to create a thread
		OddNumber odd = new OddNumber();
		Thread oddThread = new Thread(odd);
		oddThread.start();
		
		//Extending-thread way to create a thread
		Thread evenThread = new EvenNumber();
		evenThread.start();
		
		System.out.println("End Main Thread");
	}

}
