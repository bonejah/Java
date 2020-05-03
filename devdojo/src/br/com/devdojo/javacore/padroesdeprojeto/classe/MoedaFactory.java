package br.com.devdojo.javacore.padroesdeprojeto.classe;

public class MoedaFactory {
	
	public static Moeda criarMoeda(Pais pais) {
		if (pais.equals(Pais.BRASIL)) {
			return new Real();
		} else if (pais.equals(Pais.EUA)) {
			return new USDolar();
		}
		
		throw new IllegalArgumentException("Não existe esse pais");
	}

}
