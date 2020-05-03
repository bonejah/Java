package operadores;

public class TestaOperadoresLogicos {

//	The && and || operators "short-circuit", meaning they don't evaluate the right hand side if it isn't 
//	necessary.
//
//	The & and | operators, when used as logical operators, always evaluate both sides.
	
	public static void main(String[] args) {
		System.out.println(1 == 1 & 1 > 2);
		System.out.println(1 == 1 | 1 > 2);
		System.out.println(1 == 1 ^ 1 > 2);
		System.out.println(!(1 == 1));
		
		System.out.println("============");
		
		System.out.println(1 == 1 && 1 > 2);
		System.out.println(1 != 1 && 1 > 2);
		System.out.println(1 == 1 || 1 > 2);
		System.out.println(1 == 1 ^ 1 > 2);
		System.out.println(!(1 == 1));
	}

}
