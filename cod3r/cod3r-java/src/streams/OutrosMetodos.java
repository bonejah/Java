package streams;

import java.util.Arrays;
import java.util.List;

public class OutrosMetodos {

	public static void main(String[] args) {
		Aluno bianca = new Aluno("Bianca", 7.1);
		Aluno leticia = new Aluno("Leticia", 6.1);
		Aluno matheus = new Aluno("Matheus", 8.1);
		Aluno bruno = new Aluno("Bruno", 10);
		Aluno bianca1 = new Aluno("Bianca", 7.1);
		Aluno leticia2 = new Aluno("Leticia", 6.1);
		Aluno matheus3 = new Aluno("Matheus", 8.1);
		Aluno bruno4 = new Aluno("Bruno", 10);

		List<Aluno>  alunos = Arrays.asList(
				bianca, 
				leticia, 
				matheus, 
				bruno,
				bianca1, 
				leticia2, 
				matheus3, 
				bruno4);
		
		System.out.println("distinct...");
		alunos.stream()
			.distinct()
			.forEach(System.out::println);
		
		System.out.println("\n Skip/Limit");
		alunos.stream()
			.skip(2)
			.limit(3)
			.forEach(System.out::println);
		
		System.out.println("\n TakeWhile");
		alunos.stream()
			.distinct()
			.skip(2)
			.takeWhile(a -> a.nota > 7)
			.forEach(System.out::println);
		
	}

}
