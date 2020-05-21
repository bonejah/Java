package fundamentos.operadores;

public class Unarios {

	public static void main(String[] args) {
		int a = 1;
		int b = 2;
		
		System.out.println(a);
		System.out.println(b + "\n");
		
		a++; // a = a + 1;
		System.out.println(a);

		a--; // a = a - 1;
		System.out.println(a + "\n");
		
		++b;
		System.out.println(b);

		--b;
		System.out.println(b);
		
		System.out.println("Mini Desafio");
		System.out.println(++a == b--);
		System.out.println(a == b);
		
		System.out.println(a);
		System.out.println(b);
		
	}
	
}
