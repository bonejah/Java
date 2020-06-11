package colecoes;

import java.util.ArrayList;

public class Lista {

	/**
	 * List
	 * - Pode ser heterogeneo
	 * - Pode ser homogeneo
	 * - Aceita objetos duplicados
	 * - É ordenado
	 * - É indexado
	 */
	public static void main(String[] args) {
		ArrayList<Usuario> lista = new ArrayList<>();
		Usuario u1 = new Usuario("Ana");
		
		lista.add(u1);
		lista.add(new Usuario("Bruno"));
		lista.add(new Usuario("Lia"));
		lista.add(new Usuario("Bia"));
		lista.add(new Usuario("Manu"));
		
		System.out.println(lista.get(3));
		
		System.out.println(">>>> " + lista.remove(1));
		System.out.println(lista.remove(new Usuario("Manu")));
		System.out.println("Tem ?" + lista.contains(new Usuario("Lia")));
		
		for (Usuario usuario : lista) {
			System.out.println(usuario);
		}
	}
	
}
