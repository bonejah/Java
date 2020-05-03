package br.com.devdojo.javacore.abstrata;

public class Vendedor extends Funcionario {
	private double totalVendas;
	
	public Vendedor() { }
	
	public Vendedor(String nome, String clt, double salario, double totalVendas) {
		super(nome, clt, salario);
		this.totalVendas = totalVendas;
	}

	@Override
	public void calcularSalario() {
		this.salario = this.salario + (this.totalVendas * 0.05);
	}
	
	@Override
	public void print() {
		System.out.println("Imprimindo Vendedor");
	}

	public double getTotalVendas() {
		return totalVendas;
	}

	public void setTotalVendas(double totalVendas) {
		this.totalVendas = totalVendas;
	}

}
