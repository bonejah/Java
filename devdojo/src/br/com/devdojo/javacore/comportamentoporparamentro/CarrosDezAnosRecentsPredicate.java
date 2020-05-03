package br.com.devdojo.javacore.comportamentoporparamentro;

import java.util.Calendar;

public class CarrosDezAnosRecentsPredicate implements CarroPredicate {

	@Override
	public boolean test(Carro carro) {
		return carro.getAno() > (Calendar.getInstance().get(Calendar.YEAR)) - 10;
	}

}
