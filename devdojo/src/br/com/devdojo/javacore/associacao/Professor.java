package br.com.devdojo.javacore.associacao;

public class Professor {
	private String nome;
	private String especialidade;
	private Seminario[] seminarios;

	public Professor() {

	}

	public Professor(String nome, String especialidade) {
		this.nome = nome;
		this.especialidade = especialidade;
	}

	public Professor(String nome, String especialidade, Seminario[] seminarios) {
		this(nome, especialidade);
		this.seminarios = seminarios;
	}

	public void print() {
		System.out.println("------------- Relatório Professor -------------");
		System.out.println("Nome: " + this.nome);
		System.out.println("Especialidade: " + this.especialidade);

		if (this.seminarios != null && this.seminarios.length > 0) {
			System.out.println("Seminarios participantes");
			for (Seminario seminario : seminarios) {
				System.out.println(seminario.getTitulo());
			}
			return;
		}
		
		System.out.println("Professor não vinculado a nenhum seminário!!!");
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEspecialidade() {
		return especialidade;
	}

	public void setEspecialidade(String especialidade) {
		this.especialidade = especialidade;
	}

	public Seminario[] getSeminarios() {
		return seminarios;
	}

	public void setSeminarios(Seminario[] seminarios) {
		this.seminarios = seminarios;
	}

}
