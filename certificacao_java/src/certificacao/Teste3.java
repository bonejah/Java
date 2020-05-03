package certificacao;

class Pessoa1 {
	
	static int id = 1;
	
	static void m1() {
		System.out.println(id);
	}
	
}

public class Teste3 {

	public static void main(String[] args) {
		Pessoa1 p = new Pessoa1();
		System.out.println(p.id);
		System.out.println(Pessoa1.id);
		Pessoa1.m1();
	}
	
}
