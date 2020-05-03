package br.com.devdojo.javacore.associacao;

public class Seminario {
	private String titulo;
	private Aluno[] alunos;
	private Professor professor;
	private Local local;

	public Seminario() {
	}

	public Seminario(String titulo, Aluno[] alunos, Professor professor, Local local) {
		super();
		this.titulo = titulo;
		this.alunos = alunos;
		this.professor = professor;
		this.local = local;
	}

	public Seminario(String titulo) {
		this.titulo = titulo;
	}

	public void print() {
		System.out.println("------------- Relatório Seminário -------------");
		System.out.println("Titulo: " + this.titulo);
		System.out.println("Professor: " + this.professor.getNome());
		
		if (this.local != null)
			System.out.println("Local: " + this.local.getRua() + ", Bairro: " + this.local.getBairro());
		else 
			System.out.println("Nenhum local cadastrado para o seminário!!");

		if (this.alunos != null && this.alunos.length > 0) {
			System.out.println("Alunos participantes: ");
			for (Aluno aluno : alunos) {
				System.out.println(aluno.getNome());
			}
			return;
		} 
		
		System.out.println("Não existem alunos participantes do seminário!!");
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Aluno[] getAlunos() {
		return alunos;
	}

	public void setAlunos(Aluno[] alunos) {
		this.alunos = alunos;
	}

	public Professor getProfessor() {
		return professor;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
	}

	public Local getLocal() {
		return local;
	}

	public void setLocal(Local local) {
		this.local = local;
	}

}
