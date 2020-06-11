package colecoes;

import java.util.HashSet;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

public class ConjuntoOrdenado {

	public static void main(String[] args) {
		Set<String> lista = new HashSet<String>(); // Nao garante ordem de inserção
		lista.add("Ana");
		lista.add("Carlos");
		lista.add("Luca");
		lista.add("Pedro");

		for (String candidato : lista) {
			System.out.println(candidato);
		}

		System.out.println("--------------------------");

		SortedSet<String> listaTreeSet = new TreeSet<String>(); // Garante ordem de inserção
		listaTreeSet.add("Pedro");
		listaTreeSet.add("Carlos");
		listaTreeSet.add("Luca");
		listaTreeSet.add("Ana");

		for (String candidato : listaTreeSet) {
			System.out.println(candidato);
		}

		System.out.println("--------------------------");

		Set<Integer> listaSet = new HashSet<Integer>(); // Garante ordem de inserção
		listaSet.add(120);
		listaSet.add(10);
		listaSet.add(-1);
		listaSet.add(1);

		for (int nums : listaSet) {
			System.out.println(nums);
		}
	}

}
