package br.com.devdojo.javacore.blocodeinicializacao;

public class Cliente {

	private int[] parcelas;

	{
		System.out.println("Dentro do bloco de inicialização");
		parcelas = new int[100];
		for (int i = 1; i <= 100; i++) {
			parcelas[i -1] = i;
		}
	}
	
	public Cliente() {}

	public int[] getParcelas() {
		return parcelas;
	}

	public void setParcelas(int[] parcelas) {
		this.parcelas = parcelas;
	}

}
