package certificacao;

class Bla {
	static int a;
//	int a; -- Erro não pode ter 2 variaveis com o mesmo nome
	
	static int x = 0;
	public static void setX(int x) {
		Bla.x = x;
	}
	
	int y = 0;
	public void setY(int y) {
		this.y = y;
	}
}

class X {
	int a = 10;
	
	public void metodo() {
		int a = 20;
		System.out.println(a);
	}
}


public class Teste4 {

	public static void main(String[] args) {
		int a = 0;
//		int a = 10; -- Erro não pode ter 2 variaveis com o mesmo nome
		
		X x = new X();
		x.metodo();
	}
}
