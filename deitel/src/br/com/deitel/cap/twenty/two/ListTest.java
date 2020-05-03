package br.com.deitel.cap.twenty.two;

public class ListTest {
	public static void main(String[] args) {
		List<Integer> list = new List<Integer>(); // cria uma List
		
		// insere inteiros na lista
		list.insertAtFront(-1);
		list.print();
		list.insertAtFront(0);
		list.print();
		list.insertAtBack(1);
		list.print();
		list.insertAtBack(5);
		list.print();
		list.insertAtBack(7);
		list.print();
		
		// remove objetos da lista; imprime depois de cada remocao
		try {
			int removedItem = list.removeFromFront();
			System.out.printf("\n%d removed\n", removedItem);
			list.print();
			
			removedItem = list.removeFromFront();
			System.out.printf("\n%d removed\n", removedItem);
			list.print();
			
			removedItem = list.removeFromBack();
			System.out.printf("\n%d removed\n", removedItem);
			list.print();
			
			removedItem = list.removeFromBack();
			System.out.printf("\n%d removed\n", removedItem);
			list.print();
		} catch (EmptyListException emptyListException) {
			emptyListException.printStackTrace();
		}
	}
}
