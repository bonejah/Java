package hackerhank;

public class Test2 {

	public static void main(String[] args) {
		methodA(7, "methodA");
		methodB(70, "methodB");
	}

	public static synchronized void methodA(int i, String msg) {
		long inicio = System.currentTimeMillis();
		System.out.println(Integer.toString(i));
		System.out.println(msg);
		long fim = System.currentTimeMillis();
		long result = fim - inicio; 
		System.out.println("tempo gasto methodA: " + result);
	}
	
	public static void methodB (int i, String msg) {
		synchronized (Test2.class) {
			long inicio = System.currentTimeMillis();
			System.out.println(Integer.toString(i));
			System.out.println(msg);
			long fim = System.currentTimeMillis();
			long result = fim - inicio; 
			System.out.println("tempo gasto methodB: " + result);
		}
	}

}
