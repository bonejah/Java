package controle;

public class For3 {

	public static void main(String[] args) {

//		int i = 0;
//		for (i = 0; i < 10; i++) {
//			System.out.println(i);
//		}
//
//		System.out.println("Saiu do for");
//		System.out.println(i);

		for (int a = 0; a < 10; a++) {
			for (int b = 0; b < 10; b++) {
				System.out.printf("[%d %d] ", a, b);
			}
			
			System.out.println();
		}
	}

}
