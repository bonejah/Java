package generics;

public class CaixaNumeroTeste {

	public static void main(String[] args) {
		CaixaNumero<Number> caixaNumero = new CaixaNumero<>();
		caixaNumero.guardar(10l);
		System.out.println(caixaNumero.abrir());

		CaixaNumero<Integer> caixaNumero2 = new CaixaNumero<>();
		caixaNumero2.guardar(1);
		System.out.println(caixaNumero2.abrir());
		
		CaixaNumero<Double> caixaNumero3 = new CaixaNumero<>();
		caixaNumero3.guardar(100.1);
		System.out.println(caixaNumero3.abrir());
	}
}
