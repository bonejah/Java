package operadores;

public class TestaFor {

	public static void main(String[] args) {
		int a = 1;
		while(a <= 10) {
			System.out.println(a);
			a++;
		}
		
		for(int j = 1; j <=10; j++) {
			System.out.println(j);
		}
		
		for(int i =0, j = 10; i < 10; i++, j--) {
			System.out.println(i + " - " + j);
		}
		
	}
	
}
