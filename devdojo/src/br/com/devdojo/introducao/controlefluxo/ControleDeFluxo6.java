package br.com.devdojo.introducao.controlefluxo;

public class ControleDeFluxo6 {

	public static void main(String[] args) {
		double valorTotalCarro = 30000;

		for (int numeroParcela = (int) valorTotalCarro; numeroParcela >= 1; numeroParcela--) {
			double valorParcela = valorTotalCarro / numeroParcela;

			if (valorParcela < 1000) {
				continue;
			}

			System.out.println("Parcela: " + numeroParcela + "X R$: " + valorParcela);
		}
	}
}
