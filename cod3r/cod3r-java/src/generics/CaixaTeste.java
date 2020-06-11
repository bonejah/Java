package generics;

public class CaixaTeste {

	public static void main(String[] args) {
		Caixa<String> caixa = new Caixa<String>();
		caixa.guardar("Teste");
		System.out.println(caixa.abrir());

		Caixa<Integer> caixa2 = new Caixa<Integer>();
		caixa2.guardar(7);
		System.out.println(caixa2.abrir());
	}
}
