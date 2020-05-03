package operadores;

public class TestaDoWhile {

	public static void main(String[] args) {
		int i = 1;

		while (i < 10) {
			System.out.println(i);
			i++;
		}

		int j = 20;
		do {
			System.out.println(j);
			j++;
		} while (j < 10);
	}

}
