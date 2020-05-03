package br.com.devdojo.javacore.optional;

public class Carro {

	private Seguradora2 seguradora;
	private String nome;

	public String getNomeSeguradora(Pessoa p) {
		if (p != null) {
			Carro carro = p.getCarro();
			if (carro != null) {
				Seguradora2 seguradora = carro.getSeguradora();
				if (seguradora != null) {
					return seguradora.getNome();
				}
			}
		}
		
		return "";
	}

	public Seguradora2 getSeguradora() {
		return seguradora;
	}

	public void setSeguradora(Seguradora2 seguradora) {
		this.seguradora = seguradora;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
