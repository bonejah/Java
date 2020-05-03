package br.com.devdojo.javacore.metodos;

public class Estudante {

	private String nome;
	private int idade;
	private double[] notas;
	private boolean isAprovado;

	public void imprime() {
		System.out.println("Nome: " + getNome());
		System.out.println("Idade: " + getIdade());
		verificaMediaNotas(notas);
	}

	private void verificaMediaNotas(double[] notas) {
		if (notas == null) {
			System.out.println("Este aluno não possui notas...!!!");
			return;
		}

		for (int i = 0; i < notas.length; i++) {
			System.out.println("Nota " + (i + 1) + " : " + notas[i]);
		}

		int soma = 0;
		double media = 0;

		for (double nota : notas) {
			soma += nota;
		}

		media = soma / notas.length;

		if (media > 6) {
			isAprovado = true;
			System.out.println("A média é : " + media + ", Situação: Aprovado");
		} else {
			isAprovado = false;
			System.out.println("A média é : " + media + ", Situação: Reprovado");
		}
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		if (idade <= 0) {
			System.out.println("A idade não pode ser: " + idade);
			return;
		}
		this.idade = idade;
	}

	public double[] getNotas() {
		return notas;
	}

	public void setNotas(double[] notas) {
		this.notas = notas;
	}

	public boolean isAprovado() {
		return isAprovado;
	}

}
