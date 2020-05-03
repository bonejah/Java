// declaração do pacote
package certificacao;

// comentário antes do import
import java.util.*; // ou aqui o comentário do import
import java.io.*;

/**
 * Comentário Javadoc
 * @author brunolima
 *
 */
public class Pessoa {
	
	/* tudo que estiver aqui é comentário também*/
	String nome;
	static int totalDePessoas = 0;
	
	public Pessoa(String nome) {
		this.nome = nome;
	}
	
	public String getNome() {
		String sobreNome = " Lima";
		return nome + sobreNome;
	}
	
	
	public static void main(String[] args) {
		System.out.println("Classe Pessoa");
		
		Pessoa pessoa = new Pessoa("Felipe");
		System.out.println(pessoa.nome);
		System.out.println(pessoa.getNome());
	}
}

class B {
	int B;
	
	B() {
		
	}
	
	void B() {
		
	}
}

interface A {
	public static final int TAMANHO = 5;
	public abstract void autentica(String nome, String senha);
}

interface Figura {
	
} 