package fundamentos.operadores;

public class Logicos {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
//		boolean condicao1 = true;
//		boolean condicao2 = 3 > 7;
		
//		System.out.println(condicao1 && condicao2); // false
//		System.out.println(condicao1 || condicao2); // true
//		System.out.println(condicao1 ^ condicao2); // true
//		System.out.println(!condicao1); // false
//		System.out.println(!condicao2); // true
//		System.out.println(" ===================== ");
		
		System.out.println("Tabela verdade E (AND)");
		System.out.println(true && true);
		System.out.println(true && false);
		System.out.println(false && true);
		System.out.println(false && false);
		
		System.out.println("\nTabela verdade OU (OR)");
		System.out.println(true || true);
		System.out.println(true || false);
		System.out.println(false || true);
		System.out.println(false || false);
		
		System.out.println("\nTabela verdade OU Exclusivo (XOR)");
		System.out.println(true ^ true);
		System.out.println(true ^ false);
		System.out.println(false ^ true);
		System.out.println(false ^ false);
		
		System.out.println("\nTabela verdade Negacao (NOT)");
		System.out.println(!true);
		System.out.println(!false);
		
	}
}
