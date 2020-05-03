package br.com.devdojo.javacore.associacao.teste;

import br.com.devdojo.javacore.associacao.Aluno;
import br.com.devdojo.javacore.associacao.Local;
import br.com.devdojo.javacore.associacao.Professor;
import br.com.devdojo.javacore.associacao.Seminario;

public class AssociacaoTeste {

	public static void main(String[] args) {
		Seminario seminario = new Seminario("Como aprender Java");
		Aluno aluno1 = new Aluno("Bruno", 37);
		Aluno aluno2 = new Aluno("Leticia", 34);
		Professor professor = new Professor("Jose", "Java");
		Local local = new Local("Rua das Araras", "Mato");

		aluno1.setSeminario(seminario);
//		aluno2.setSeminario(seminario);

		seminario.setProfessor(professor);
//		seminario.setLocal(local);
		seminario.setAlunos(new Aluno[] { aluno1 });
//		seminario.setAlunos(new Aluno[] { aluno1, aluno2 });

		professor.setSeminarios(new Seminario[] { seminario });

		seminario.print();
		professor.print();
		aluno1.print();
		aluno2.print();
		local.print();
	}
}
