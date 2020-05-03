package br.com.devdojo.javacore.polimorfismo;

public class Gerente extends Funcionario {
	private double participacaoDosLucros;

	public Gerente(String nome, double salario, double participacaoDosLucros) {
		super(nome, salario);
		this.participacaoDosLucros = participacaoDosLucros;
	}

	public double getParticipacaoDosLucros() {
		return participacaoDosLucros;
	}

	public void setParticipacaoDosLucros(double participacaoDosLucros) {
		this.participacaoDosLucros = participacaoDosLucros;
	}

	@Override
	public String toString() {
		return "Gerente [participacaoDosLucros=" + participacaoDosLucros + "]";
	}

	@Override
	public void calcularPagamento() {
		this.salario = this.salario + this.participacaoDosLucros;
	}

}
