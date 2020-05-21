package colecoes;

import java.util.LinkedList;
import java.util.Queue;

public class Fila {

	public static <E> void main(String[] args) {
		Queue<String> fila = new LinkedList<String>();
		
		// Offer e Add -> Adicionam elementos na fila
		// A diferença é o comportamento quando a fila está cheia.
		
		fila.add("Ana"); 		// retorna false;		
		fila.offer("Bia");		// lança uma exception
		fila.add("Carlos");
		fila.offer("Daniel");
		fila.add("Rafaela");
		fila.offer("Gui");
		
		// Peek e Element -> Obtem o proximo elemento da fila sem remover
		// A diferença é o comportamento quando a fila está vazia.
		
//		System.out.println(fila.peek()); // se fila vazia, retorna null
//		System.out.println(fila.peek());
//		System.out.println(fila.element()); // se fila vazia, retorna exception
		
		for (String nome : fila) {
			System.out.println(nome);
		}
		
		System.out.println("------------");
		
		
		// Poll e Remove -> Obtem o proximo elemento da fila e remove
		// A diferença do comportamento ocorre quando a fila está vazia!
		
		System.out.println(fila.poll()); // se fila vazia, retorna null
		System.out.println(fila.poll());
		System.out.println(fila.poll());
		System.out.println(fila.poll());
		System.out.println(fila.poll());
		System.out.println(fila.poll());
		System.out.println(fila.poll());
		System.out.println(fila.remove()); // se fila vazia, retorna exception
		
//		fila.size();
//		fila.clear();
//		fila.isEmpty();
//		fila.contains(...);
		
	}
}
