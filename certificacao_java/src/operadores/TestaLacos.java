package operadores;

public class TestaLacos {

	public static void main(String[] args) {
		int j = 9;
		while(j < 10) {
			System.out.println("while " + j);
			j++;
		}
		
		j = 9;
		do {
			System.out.println("do..while " + j);
			j++;
		} while(j < 10);
		
		
		for (j = 9 ; j <10 ; j++) {
			System.out.println("for "+ j);
		}
	}
}
