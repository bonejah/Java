package certificacao;

public class Teste2 {

	String nome = "Bruno";
	String nomeCompleto = nome + " Lima";

	public Teste2() {
		System.out.println(nome);
	}

	public void m1() {
		System.out.println(nomeCompleto);
	}

	public static void main(String[] args) {
		Teste2 teste2 = new Teste2();
		teste2.m1();
		teste2.nome = "Leticia";
		System.out.println(teste2.nome);
	}

}
