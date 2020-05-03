package br.com.devdojo.javacore.colecoes.classes;

public class Produto implements Comparable<Produto> {

	private String serialNumber;
	private String nome;
	private double preco;
	private int quantidade;

	public Produto(String serialNumber, String nome, double preco) {
		this.serialNumber = serialNumber;
		this.nome = nome;
		this.preco = preco;
	}

	public Produto(String serialNumber, String nome, double preco, int quantidade) {
		this.serialNumber = serialNumber;
		this.nome = nome;
		this.preco = preco;
		this.quantidade = quantidade;
	}

	public String getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((serialNumber == null) ? 0 : serialNumber.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Produto other = (Produto) obj;
		if (serialNumber == null) {
			if (other.serialNumber != null)
				return false;
		} else if (!serialNumber.equals(other.serialNumber))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Produto [serialNumber=" + serialNumber + ", nome=" + nome + ", preco=" + preco + ", quantidade="
				+ quantidade + "]";
	}

	@Override
	public int compareTo(Produto produto) {
		// negativo se thisObject < outroObjeto
		// Zerp se thisObject == outroObjeto
		// positivo se thisObject > outroObjeto
		
		return Double.compare(this.preco, produto.preco);
//		return this.serialNumber.compareTo(produto.getSerialNumber());
	}

}
