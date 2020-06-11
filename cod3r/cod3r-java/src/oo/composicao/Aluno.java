package oo.composicao;

import java.util.ArrayList;
import java.util.List;

public class Aluno {

	final String nome;
	final List<Curso> cursos = new ArrayList<Curso>();

	public Aluno(String nome) {
		this.nome = nome;
	}

	void adicionarCurso(Curso curso) {
		this.cursos.add(curso);
		curso.alunos.add(this);
	}
	
	Curso obterCursoPorNome(String nome) {
		for (Curso curso : cursos) {
			if (curso.nome.equals(nome)) {
				return curso;
			}
		}
		
		return null;
	}

	@Override
	public String toString() {
		return "Aluno [nome=" + nome + "]";
	}
	
}