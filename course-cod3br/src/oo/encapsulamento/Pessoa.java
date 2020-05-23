package oo.encapsulamento;

public class Pessoa {

	private int idade;

	public Pessoa(int idade) {
		this.idade = idade;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		if (idade >= 0 && idade <= 120) {
			this.idade = idade;
		}
	}

}
