package br.com.devdojo.javacore.exception.runtimeexception;

public class RuntimeExceptionTest2 {

	public static void main(String[] args) {
		try {
			divisao(10, 0);
		} catch (RuntimeException e) {
			System.err.println(e.getMessage());
			e.printStackTrace();
		}
	}
	
	public static void divisao(int num1, int num2) {
		if (num2 <= 0) {
			throw new IllegalArgumentException("Informe um valor diferente de ZERO para num2"); 
		}
		
		int result = num1/num2;
		System.out.println(result);
	}

}
