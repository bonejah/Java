package br.com.devdojo.javacore.completablefuture;

import java.util.concurrent.TimeUnit;

public class Desconto {

	public enum Codigo {
		NENHUM(0), SILVER(5), GOLD(10), PLATINUM(15), ELITE(20);

		private final int porcentagem;

		Codigo(int porcentagem) {
			this.porcentagem = porcentagem;
		}

		public int getPorcentagem() {
			return porcentagem;
		}
	}

	public static String calcularDesconto(Orcamento orcamento) {
		return String.format("%s o preco eh: %.2f", orcamento.getNomeLoja(), 
				calculo(orcamento.getPreco(), orcamento.getCodigoDesconto() ));
	}

	private static double calculo(double preco, Codigo codigo) {
		delay();
		return preco * (100 - codigo.porcentagem) / 100;
	}

	private static void delay() {
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
