package fundamentos.string;

import java.util.Scanner;

public class TipoStringEquals {

	public static void main(String[] args) {
		System.out.println("2" == "2"); // true
		
		String s = new String("2");
		System.out.println("2" == s); // false
		System.out.println("2".equals(s)); // true
		
		Scanner entrada = new Scanner(System.in);
//		String entrada1 = entrada.next(); // Retirar os espacos em branco
//		System.out.println("2".equals(entrada1)); // true
		
		String entrada2 = entrada.nextLine(); // Nao retirar os espacos em branco
		System.out.println("2".equals(entrada2)); // false
		
		entrada.close();
	}
}
