package operadores;

public class TestaComparacao {

	public static void main(String[] args) {
		System.out.println(1 == 1 );
		System.out.println(1 != 1 );

		System.out.println("===============");
		
		System.out.println(2 >= 1);
		System.out.println(2 <= 1);
		System.out.println(2 > 1);
		System.out.println(2 < 1);

		System.out.println("===============");
		
		System.out.println(1.0f == 1.0d);
		System.out.println(1.0f == 1l);
		
		System.out.println("===============");
		
		System.out.println(true == true);
		System.out.println(true != false);
		
		System.out.println("===============");
		
		int idade = 25;
		System.out.println(idade = 1);
		
		boolean mentira = false;
		System.out.println(mentira = true);
	}
}
