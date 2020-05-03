package br.com.devdojo.javacore.modificadorstatic;

public class Cliente {

	private static int[] parcelas;

	static {
		System.out.println("Dentro do bloco de inicialização");
		parcelas = new int[100];
		for (int i = 1; i <= 100; i++) {
			parcelas[i -1] = i;
		}
	}
	
	public Cliente() {}

	public static int[] getParcelas() {
		return parcelas;
	}

}
