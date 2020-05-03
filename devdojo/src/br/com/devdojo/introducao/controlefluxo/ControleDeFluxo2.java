package br.com.devdojo.introducao.controlefluxo;

public class ControleDeFluxo2 {

	public static void main(String[] args) {
		int idade = 2;
		String status;

		if (idade > 18) {
			System.out.println("Adulto");
		} else {
			System.out.println("Nao adulto");
		}

		status = idade > 18 ? "Adulto" : "Não adulto";
		System.out.println(status);
	}

}
