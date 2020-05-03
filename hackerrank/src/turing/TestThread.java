package turing;

class NewThread extends Thread {
	
	NewThread() {
		super("My Thread");
		start();
	}
	
	@Override
	public void run() {
		System.out.println(this);
	}

}

public class TestThread {
	
	
	
	public static void main(String[] args) {
//		NewThread newThread = new NewThread();
		
		int x = 9, y = 10, z;
		z = ++x + y++;
		System.out.println(z);
		
	}
	
	
}