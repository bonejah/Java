package operadores;

import java.util.ArrayList;
import java.util.Iterator;

public class TestaArrayList2 {

	public static void main(String[] args) {
		ArrayList<String> nomes = new ArrayList<>();
		nomes.add("Java");
		nomes.add("Ruby");
		nomes.add("Scala");
		
		Iterator<String> it = nomes.iterator();
		while(it.hasNext()) {
			String atual = it.next();
			System.out.println(atual);
//			it.remove();
		}
		
		System.out.println(nomes.size());
		
		for(String nome: nomes) {
			System.out.println(nome);
		}
		
		ClienteNovo bruno = new ClienteNovo();
		bruno.nome = "bruno";
		
		ArrayList<ClienteNovo> clientes = new ArrayList<ClienteNovo>();
		clientes.add(bruno);
		System.out.println(bruno.nome);
		System.out.println(clientes.get(0).nome);
		
		bruno.nome = "paulo";
		System.out.println(bruno.nome);
		System.out.println(clientes.get(0).nome);
	}
}
