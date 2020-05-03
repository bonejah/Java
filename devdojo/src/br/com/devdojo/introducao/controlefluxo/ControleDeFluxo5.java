package br.com.devdojo.introducao.controlefluxo;

public class ControleDeFluxo5 {

	public static void main(String[] args) {
		double valorTotalCarro = 30000;

		for (int numeroParcela = 1; numeroParcela <= valorTotalCarro; numeroParcela++) {
			double valorParcela = valorTotalCarro / numeroParcela;

			if (valorParcela < 1000) {
				break;
			}
			
			System.out.println("Parcela: " + numeroParcela + "X R$: " + valorParcela);
		}
	}
}
