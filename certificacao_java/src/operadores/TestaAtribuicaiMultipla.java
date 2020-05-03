package operadores;

public class TestaAtribuicaiMultipla {

	public static void main(String[] args) {
		int a = 15, b = 20, c = 30;
		b = c;
		System.out.println(a);
		System.out.println(b);
		System.out.println(c);
		
		System.out.println(" =========== ");
		
		a = (b = c);
		System.out.println(a);
		System.out.println(b);
		System.out.println(c);
	}
}
