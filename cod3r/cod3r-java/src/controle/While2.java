package controle;

import java.util.Scanner;

public class While2 {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String valor = "";
		
		while(!valor.equalsIgnoreCase("sair")) {
			System.out.println("Você diz: ");
			valor = scanner.nextLine();
		}
		
		scanner.close();
	}
}
