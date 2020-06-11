package streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MinMax {

	public static void main(String[] args) {
		Aluno bianca = new Aluno("Bianca", 7.1);
		Aluno leticia = new Aluno("Leticia", 6.1);
		Aluno matheus = new Aluno("Matheus", 8.1);
		Aluno bruno = new Aluno("Bruno", 10);
		
		List<Aluno> alunos = Arrays.asList(bianca, leticia, matheus, bruno);
		
		Comparator<Aluno> melhorNota = (a1, a2) -> {
			if (a1.nota > a2.nota) return 1;
			if (a1.nota < a2.nota) return -1;
			return 0;
		};

		Comparator<Aluno> piorNota = (a1, a2) -> {
			if (a1.nota > a2.nota) return -1;
			if (a1.nota < a2.nota) return 1;
			return 0;
		};
		
		
		System.out.println(alunos.stream().max(melhorNota).get());
		System.out.println(alunos.stream().min(melhorNota).get());
		System.out.println(alunos.stream().max(piorNota).get());
		System.out.println(alunos.stream().min(piorNota).get());
		
	}
	
}
