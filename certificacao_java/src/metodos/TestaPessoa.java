package metodos;

public class TestaPessoa {

	public static void main(String[] args) {
		Pessoa pessoa = new Pessoa();
		pessoa.setNome("Bruno", 39);
		
		String nome = pessoa.getNome();
		System.out.println(nome);
		
		
		System.out.println(pessoa.getNome());
		
	}
}
