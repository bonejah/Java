package streams;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class Match {

	public static void main(String[] args) {
		Aluno bianca = new Aluno("Bianca", 7.1);
		Aluno leticia = new Aluno("Leticia", 7.1);
		Aluno matheus = new Aluno("Matheus", 8.1);
		Aluno bruno = new Aluno("Bruno", 10);
		
		List<Aluno> alunos = Arrays.asList(bianca, leticia, matheus, bruno);
		Predicate<Aluno> aprovado = a -> a.nota >= 7;
		System.out.println("Todos alunos aprovados?: " + alunos.stream().allMatch(aprovado));
		System.out.println("Algum aluno aprovado?: " + alunos.stream().anyMatch(aprovado));
		System.out.println("Nenhum aluno aprovado?: " + alunos.stream().noneMatch(aprovado));
		
	}
	
}
