package certificacao;

public class Teste {
	
	public static void main(String[] args) {
		Teste teste = new Teste();
		teste.m1();
		teste.m2();
		teste.m3("Bruno");
	}
	
	public void m1() {
		int x = 10;
		
		if (x >= 10) {
			int y = 50;
			System.out.println(y);
		}
		
//		System.out.println(y); -- Erro pois a variável y foi definida somente dentro do if*
		System.out.println(x);
	}
	
	public void m2() {
		for (int i = 0, j= 0; i <= 10; i++) j++;
//			System.out.println(i); -- Erro compilação pois o escopo do i e do j estão na mesma linha do for* sem chaves {}
//			System.out.println(j); -- Erro compilação pois o escopo do i e do j estão na mesma linha do for* sem chaves {}
	}
	
	public void m3(String nome) {
		System.out.println(nome);
	}
	
}
