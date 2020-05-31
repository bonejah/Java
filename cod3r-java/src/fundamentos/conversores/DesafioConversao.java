package fundamentos.conversores;

import java.util.Scanner;

public class DesafioConversao {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Informe o 1 salário: ");
		String s1 = sc.nextLine().replace(",", ".");
		
		System.out.println("Informe o 2 salário: ");
		String s2 = sc.nextLine().replace(",", ".");
		
		System.out.println("Informe o 3 salário: ");
		String s3 = sc.nextLine().replace(",", ".");
		
		sc.close();
		
		Double d1 = Double.parseDouble(s1);
		Double d2 = Double.parseDouble(s2);
		Double d3 = Double.parseDouble(s3);
		Double media = ((d1 + d2 + d3) / 3);
		
		System.out.format("A média salarial é: %.02f", media);
	}
	
}
