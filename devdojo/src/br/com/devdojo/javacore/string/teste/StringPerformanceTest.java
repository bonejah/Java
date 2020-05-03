package br.com.devdojo.javacore.string.teste;

public class StringPerformanceTest {

	public static void main(String[] args) {
		long inicio = System.currentTimeMillis();
		concatString(100000);
		long fim = System.currentTimeMillis();
		System.out.println("Tempo gasto com String: " + (fim - inicio) + " em ms");
		
		long inicioSb = System.currentTimeMillis();
		concatStringBuilder(500000);
		long fimSb = System.currentTimeMillis();
		System.out.println("Tempo gasto com StringBuilder: " + (fimSb - inicioSb) + " em ms");
		
		long inicioSbf = System.currentTimeMillis();
		concatStringBuffer(500000);
		long fimSbf = System.currentTimeMillis();
		System.out.println("Tempo gasto com StringBuffer: " + (fimSbf - inicioSbf) + " em ms");
	}

	private static void concatString(int tam) {
		String string = "";

		for (int i = 0; i < tam; i++) {
			string += i;
		}
	}
	
	private static void concatStringBuilder(int tam) {
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < tam; i++) {
			sb.append(i);
		}
	}
	
	private static void concatStringBuffer(int tam) {
		StringBuffer sbf = new StringBuffer();

		for (int i = 0; i < tam; i++) {
			sbf.append(i);
		}
	}
}
