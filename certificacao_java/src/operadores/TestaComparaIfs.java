package operadores;

public class TestaComparaIfs {

	public static void main(String[] args) {
		boolean autentico = true;

		if (autentico) {
			System.out.println("OK");
		} else {
			System.out.println("NOK");
		}

		if (1 < 2) {
			System.out.println("OK");
		}

		boolean valor = true;
		if (valor == false) {
			System.out.println("false");
		}

		if (valor) {
			System.out.println("valor");
		}

		int a = 0, b = 3;
		if (a == b) {
			System.out.println("iguais");
		}

		if (valor = false) {
			System.out.println("false");
		}

		boolean v = true;
		if (v) {
			System.out.println("true");
		} else if (v) {
			System.out.println("false");
		} else if (!v) {
			System.out.println("false");
		} else {
			System.out.println("so else ");
		}

		if (autentico)
			System.out.println("autentico");
		else
			System.out.println("Falhou");
		System.out.println("Tente novamente");

		int valor2 = 100;
		if (valor2 > 200)
			if (valor2 < 400)
				if (valor2 > 300)
					System.out.println("a");
				else
					System.out.println("b");
			else
				System.out.println("c");
	}

}
