package streams;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Predicate;

public class Reduce3 {

	public static void main(String[] args) {
		Aluno bianca = new Aluno("Bianca", 7.1);
		Aluno leticia = new Aluno("Leticia", 6.1);
		Aluno matheus = new Aluno("Matheus", 8.1);
		Aluno bruno = new Aluno("Bruno", 10);
		
		List<Aluno> alunos = Arrays.asList(bianca, leticia, matheus, bruno);
		Predicate<Aluno> aprovado = a -> a.nota >= 7;
		Function<Aluno, Double> apenasNota = a -> a.nota;
		BiFunction<Media, Double, Media> calcularMedia = (media, nota) -> media.adicionar(nota);
		BinaryOperator<Media> combinarMedia = (m1, m2) -> Media.combinar(m1, m2);
		
		Media media = alunos.stream()
			.filter(aprovado)
			.map(apenasNota)
			.reduce(new Media(), calcularMedia, combinarMedia);
		
		System.out.println("A média da turma é: " + media.getValor());
		
	}
}
