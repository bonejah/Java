package operadores;

public class TestaComparacaoStrings2 {

	public static void main(String[] args) {
		String ab = "a" + "b"; // coloca esse valor no pool de String
		System.out.println(ab == "ab"); // true
		
		String a = "a";
		String ab2 = a + "b"; // nesse caso se cria um novo objeto String
		System.out.println(ab2 == "ab"); // false
		
		String texto = "um texto qualquer";	// coloca esse valor no pool de String
		String txt = texto.substring(3, 8); // nesse caso se cria um novo objeto String
		System.out.println(txt == "texto"); // false
		System.out.println(texto.toLowerCase() == texto); // true
		System.out.println(texto.toString() == texto); // true
		
	}
}
