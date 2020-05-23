package oo.composicao;

public class CursoAlunoTest {

	public static void main(String[] args) {
		Aluno a1 = new Aluno("Bruno");
		Aluno a2 = new Aluno("Leticia");
		Aluno a3 = new Aluno("Bianca");
		
		Curso c1 = new Curso("Java Completo");
		Curso c2 = new Curso("Web 2023");
		Curso c3 = new Curso("Reactive Native");

		c1.adicionarAluno(a1);
		c1.adicionarAluno(a2);

		c2.adicionarAluno(a1);
		c2.adicionarAluno(a3);

		a1.adicionarCurso(c3);
		a2.adicionarCurso(c3);
		a3.adicionarCurso(c3);

		System.out.println("Alunos matriculados no Curso 1...");
		for (Aluno aluno : c1.alunos) {
			System.out.println(aluno);
		}
		System.out.println();

		System.out.println("Alunos matriculados no Curso 2...");
		for (Aluno aluno : c2.alunos) {
			System.out.println(aluno);
		}
		System.out.println();

		System.out.println("Alunos matriculados no Curso 3...");
		for (Aluno aluno : c3.alunos) {
			System.out.println(aluno);
		}
		System.out.println();
		
		
		System.out.println(a1.cursos.get(0).alunos);
		System.out.println();

		Curso cursoEncontrado = a1.obterCursoPorNome("Java Completo");
		
		if (cursoEncontrado != null) {
			System.out.println(cursoEncontrado);
			System.out.println(cursoEncontrado.alunos);
		}
	}

}
