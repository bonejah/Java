package br.com.devdojo.javacore.modificadorfinal;

public class Carro {
	public static final double VELOCIDADE_FINAL = 120;
	private String nome;
	private String marca;
	private final Comprador comprador = new Comprador();
	
	public final void print() {
		System.out.println("Imprimindo um carro");
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public Comprador getComprador() {
		return comprador;
	}
	
	public static double getVelocidadeFinal() {
		return VELOCIDADE_FINAL;
	}

	@Override
	public String toString() {
		return "Carro [nome=" + nome + ", marca=" + marca + ", comprador=" + comprador + "]";
	}

}
