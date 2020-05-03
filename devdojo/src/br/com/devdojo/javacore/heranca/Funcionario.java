package br.com.devdojo.javacore.heranca;

public class Funcionario extends Pessoa {
	private double salario;
	
	static {
		System.out.println("Bloco de inicialização estático Funcionário");
	}
	
	{
		System.out.println("Bloco de inicialização Funcionário 1 ");
	}
	
	{
		System.out.println("Bloco de inicialização Funcionário 2");
	}
	
//	public Funcionario() { }
	
	public Funcionario(String nome) {
		super(nome);
		System.out.println("Dentro do construtor Funcionário");
	}
	
	@Override
	public void print() {
		super.print();
		System.out.println("Salario: " + this.salario);
	}
	
	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

}
