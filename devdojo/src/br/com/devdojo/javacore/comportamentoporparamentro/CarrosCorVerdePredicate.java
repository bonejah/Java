package br.com.devdojo.javacore.comportamentoporparamentro;

public class CarrosCorVerdePredicate implements CarroPredicate {

	@Override
	public boolean test(Carro carro) {
		return carro.getCor().equals("verde");
	}

}
