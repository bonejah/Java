package arrays;

import java.util.Scanner;

public class Matriz {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.print("Quantos alunos?");
		int qtdeAlunos = scanner.nextInt();

		System.out.print("Quantas notas por aluno?");
		int qtdeNotas = scanner.nextInt();

		double[][] notasDaTurma = new double[qtdeAlunos][qtdeNotas];
		
		double total = 0;
		
		for (int aluno = 0; aluno < notasDaTurma.length; aluno++) {
			for (int nota = 0; nota < notasDaTurma[aluno].length; nota++) {
				System.out.printf("Informe a nota %d do aluno %d ", nota + 1, aluno + 1);
				notasDaTurma[aluno][nota] = scanner.nextDouble();
				total += notasDaTurma[aluno][nota];
			}
		}
		
		double media = total / (qtdeAlunos * qtdeNotas);
		System.out.println("Média da turma é: " + media);
		
		scanner.close();
	}
}