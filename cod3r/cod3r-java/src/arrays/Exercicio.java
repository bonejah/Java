package arrays;

import java.util.Arrays;

public class Exercicio {

	public static void main(String[] args) {
		double [] notasAluno = new double [3];
		System.out.println(Arrays.toString(notasAluno));

		notasAluno[0] = 7.9;
		notasAluno[1] = 8;
		notasAluno[2] = 6.7;
		
		System.out.println(Arrays.toString(notasAluno));
		
		double totalAlunoA = 0; 
		for (int i = 0; i < notasAluno.length; i++) {
			totalAlunoA += notasAluno[i];
		}
		
		System.out.println("Total: " + totalAlunoA);
		System.out.println("Média: " + totalAlunoA / notasAluno.length);
		
		double[] notasAlunoB = {6.9, 8.9, 5.5, 10};
		System.out.println(Arrays.toString(notasAlunoB));
		
		double totalAlunoB = 0; 
		for (int i = 0; i < notasAlunoB.length; i++) {
			totalAlunoB += notasAlunoB[i];
		}
		
		System.out.println("Total: " + totalAlunoB);
		System.out.println("Média: " + totalAlunoB / notasAlunoB.length);
	}
}
