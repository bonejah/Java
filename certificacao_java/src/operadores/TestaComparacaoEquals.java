package operadores;

class Cliente {
	
	String nome;
	
	public Cliente(String nome) {
		this.nome = nome;
	}
	
	public boolean equals(Object o) {
		Cliente outro = (Cliente)o;
		return this.nome.equals(nome);  
	}
	
}

public class TestaComparacaoEquals {
	
	public static void main(String[] args) {
		Cliente c1 = new Cliente("Mario");		
		Cliente c2 = new Cliente("Luigi");
		Cliente c3 = new Cliente("Guilherme");
		
		System.out.println(c1.equals(c2)); // true
		System.out.println(c1.equals(c2)); // true
		System.out.println(c2.equals(c3)); // true
		System.out.println(c2.equals((Object)c3)); // true
	}

}
