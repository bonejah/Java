package metodos;

public class Pessoa {

	int idade;
	String nome;
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome, int idade) {
		this.nome = nome;
		this.idade = idade;
	}
	
	public void imprime() {
		System.out.println(getNome());
	}
	
}
