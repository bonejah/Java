package br.com.devdojo.javacore.colecoes.classes;

import java.util.Comparator;

public class CelularComparatorNome  implements Comparator<Celular>{

	@Override
	public int compare(Celular o1, Celular o2) {
		return o1.getNome().compareTo(o1.getNome());
	}

}