package controle;

public class For1 {

	public static void main(String[] args) {
		for (int i = 1; i <= 10; i++) {
			System.out.printf("i = %d\n", i);
		}
		
		int x = 2;
		for(; x < 10;) {
			System.out.println("x = " + x);
			x++;
		}
		
		for(;;) {
			System.out.println("Fim!");
		}
	}

}
