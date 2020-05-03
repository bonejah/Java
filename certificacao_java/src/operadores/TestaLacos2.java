package operadores;

public class TestaLacos2 {

	public static void main(String[] args) {
		int i = 0;
		lacoWhile: while (i < 10) {
			i++;
			if (i == 5) {
				break lacoWhile;
			} else {
				System.out.println("i = " + i);
			}
		}
		System.out.println("fora do while");

		i = 0;
		while (i < 10) {
			i++;
			if (i == 5) {
				continue;
			} else {
				System.out.println("i = " + i);
			}
		}
		System.out.println("fora do while");
		
		System.out.println();

		int externo = 4;
		System.out.println(externo);
		
		externo: for (int j = 0; j < 10; j++) {
			if (j == 8)
				break externo;
			if (j == 5)
				continue externo;
			System.out.println(j);
		}
	}

}
