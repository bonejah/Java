package br.com.devdojo.javacore.sobrecargametodos;

public class Funcionario {

	private String nome;
	private String cpf;
	private double salario;
	private String rg;
	
	public Funcionario(String nome) {
		this.nome = nome;
		System.out.println("Executou o construtor");
	}

	public Funcionario(String nome, String cpf, double salario) {
		this.nome = nome;
		this.cpf = cpf;
		this.salario = salario;
	}

	public Funcionario(String nome, String cpf, double salario, String rg) {
		this(nome, cpf, salario);
		this.rg = rg;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}
	
	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public void imprime() {
		System.out.println("Nome: " + this.nome);
		System.out.println("CPF: " + this.cpf);
		System.out.println("Salario: R$" + this.salario);
		System.out.println("RG: " + this.rg);
	}

}
