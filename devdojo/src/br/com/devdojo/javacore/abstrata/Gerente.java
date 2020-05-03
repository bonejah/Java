package br.com.devdojo.javacore.abstrata;

public class Gerente extends Funcionario {
	
	public Gerente(String nome, String clt, double salario) {
		super(nome, clt, salario);
	}

	@Override
	public void calcularSalario() {
		this.salario = this.salario + (this.salario * 0.2);
	}
}
