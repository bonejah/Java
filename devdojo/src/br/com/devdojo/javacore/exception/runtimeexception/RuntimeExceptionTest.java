package br.com.devdojo.javacore.exception.runtimeexception;

public class RuntimeExceptionTest {

	public static void main(String[] args) {
		int a = 10;
		int b = 2;
		Object obj = new Object();
		
		if (b > 0) {
			int c = a / b;
			System.out.println(c);
		} else {
			System.out.println("Não é possível dividir pro ZERO");
		}
		
		if (obj != null) {
			System.out.println(obj);
		}
	}

}
