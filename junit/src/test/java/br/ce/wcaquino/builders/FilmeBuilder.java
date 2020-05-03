package br.ce.wcaquino.builders;

import br.ce.wcaquino.entidades.Filme;

public class FilmeBuilder {
	
	private Filme filme;
	
	private FilmeBuilder() {}

	public static FilmeBuilder umFilme() {
		FilmeBuilder filmeBuilder = new FilmeBuilder();
		filmeBuilder.filme = new Filme("Filme1", 2, 4.0);
		return filmeBuilder;
	}
	
	public Filme agora() {
		return filme;
	}
	
	public FilmeBuilder semEstoque() {
		filme.setEstoque(0);
		return this;
	}
	
	public FilmeBuilder comValor(Double valor) {
		filme.setPrecoLocacao(valor);
		return this;
	}
}
