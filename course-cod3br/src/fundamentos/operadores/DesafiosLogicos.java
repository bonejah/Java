package fundamentos.operadores;

public class DesafiosLogicos {

	public static void main(String[] args) {
		boolean trabalho1 = false;
		boolean trabalho2 = false;
		
		boolean comprouTV50 = trabalho1 && trabalho2;
		boolean comprouTV32 = trabalho1 ^ trabalho2;
		boolean comprouSorvete = trabalho1 || trabalho2;
		boolean maisSaudavel = !comprouSorvete;
		
		System.out.println("Comprou Tv 50\"? " + comprouTV50);
		System.out.println("Comprou Tv 32\"? " + comprouTV32);
		System.out.println("Comprou Tv 32\"Sorvete? " + comprouSorvete);
		System.out.println("Mais saudavel? " + maisSaudavel);
		
	}
}
