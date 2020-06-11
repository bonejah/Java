package generics;

public class CaixaIntTeste {
	
	public static void main(String[] args) {
		CaixaInt caixaInt = new CaixaInt();
		caixaInt.guardar(1234567);
		System.out.println(caixaInt.abrir());
	}
	
}
