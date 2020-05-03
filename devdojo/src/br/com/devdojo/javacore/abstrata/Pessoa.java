package br.com.devdojo.javacore.abstrata;

public abstract class Pessoa {
	protected String nome;
	
	public abstract void print();

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public String toString() {
		return "Pessoa [nome=" + nome + "]";
	}

}
