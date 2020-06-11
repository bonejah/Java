package arrays;

import java.util.Arrays;
import java.util.Scanner;

public class DesafioArray {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.println("Informe a quantidade de notas: ");
		
		int quantidadeNotas = scanner.nextInt();
		double[] notasAluno = new double[quantidadeNotas];
		double totalNotas = 0;
		
		for (int i = 0; i < notasAluno.length; i++) {
			System.out.print("Informe a nota" + (i + 1) + " do aluno:");
			double notaAluno = scanner.nextDouble();
			notasAluno[i] = notaAluno;
			totalNotas += notaAluno; 
		}
		
		System.out.println(Arrays.toString(notasAluno));
		
		System.out.println("Media do aluno: " + (totalNotas / notasAluno.length));

		scanner.close();
	}
	
}
