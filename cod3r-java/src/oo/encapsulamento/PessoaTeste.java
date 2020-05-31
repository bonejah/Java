package oo.encapsulamento;

public class PessoaTeste {

	public static void main(String[] args) {
		Pessoa pessoa = new Pessoa(38);
		pessoa.setIdade(-30);
		pessoa.setIdade(119);
		
		System.out.println(pessoa.getIdade());
	}
}
