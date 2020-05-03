package br.com.devdojo.javacore.streams;

import java.util.Arrays;
import java.util.List;

public class Pessoa {
	private String nome;
	private int idade;
	private double salario;

	public Pessoa(String nome, int idade, double salario) {
		super();
		this.nome = nome;
		this.idade = idade;
		this.salario = salario;
	}

	public static List<Pessoa> bancoDePessoas() {
		return Arrays.asList(
				new Pessoa("Bruno", 37, 100), 
				new Pessoa("Leticia", 34, 200),
				new Pessoa("Bianca", 20, 150), 
				new Pessoa("Matheus", 19, 110), 
				new Pessoa("Matheus", 19, 110),
				new Pessoa("Tadeu", 40, 110));
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
		this.idade = idade;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
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
		Pessoa other = (Pessoa) obj;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Pessoa [nome=" + nome + ", idade=" + idade + ", salario=" + salario + "]";
	}

}
