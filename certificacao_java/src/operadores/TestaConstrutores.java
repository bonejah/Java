package operadores;

class A {
	String nome;
	int i = 15;
	int tamanho = tamanhoDoNome();

	A() {
		super();
	}
	
	A(String s) {
		this.nome = s;
		System.out.println(i);
	}
	
	int tamanhoDoNome() {
		return nome.length();
	}

}

public class TestaConstrutores {

	public static void main(String[] args) {
		A a = new A();
		A a2 = new A("Bruno");
		System.out.println(a2.i);
	}
	
}
