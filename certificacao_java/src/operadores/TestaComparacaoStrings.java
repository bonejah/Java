package operadores;

public class TestaComparacaoStrings {

	public static void main(String[] args) {
		String nome1 = new String("Mario");
		String nome2 = new String("Mario");
		System.out.println(nome1 == nome2);
		
		// No caso abaixo as variaveis nome3 e nome4 foram criadas no pool de strings,
		// e a VM fez a variavel nome4 apontar para a variavel nome3
		String nome3 = "Mario";
		String nome4 = "Mario";
		System.out.println(nome3 == nome4);
		System.out.println(nome1 == nome3);
		
		System.out.println(nome1.equals(nome3));
		
	}
}
