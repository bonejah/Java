package br.com.devdojo.javacore.polimorfismo;

public class Vendedor extends Funcionario {
	private double totalVendas;

	public Vendedor(String nome, double salario, double totalVendas) {
		super(nome, salario);
		this.totalVendas = totalVendas;
	}

	public double getTotalVendas() {
		return totalVendas;
	}

	public void setTotalVendas(double totalVendas) {
		this.totalVendas = totalVendas;
	}

	@Override
	public String toString() {
		return "Vendedor [totalVendas=" + totalVendas + "]";
	}

	@Override
	public void calcularPagamento() {
		this.salario = this.salario + (totalVendas * 0.05);
	}

}
