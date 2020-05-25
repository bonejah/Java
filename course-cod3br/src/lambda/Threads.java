package lambda;

public class Threads {

	public static void main(String[] args) {

		Runnable trabalho1 = new Trabalho1();
		Runnable trabalho2 = new Runnable() {
			@Override
			public void run() {
				for (int i = 0; i < 100; i++) {
					System.out.println("Trabalho #02 - value: " + (i + 1));
				}
			}
		};

		Runnable trabalho3 = Threads::trabalho3;

		Thread thread1 = new Thread(trabalho1);
		Thread thread2 = new Thread(trabalho2);
		Thread thread3 = new Thread(trabalho3);
		
		thread1.start();
		thread2.start();
		thread3.start();
		
	}
	
	static void trabalho3() {
		for (int i = 0; i < 100; i++) {
			System.out.println("Trabalho #03 - value: " + (i + 1));
		}
	}

}
