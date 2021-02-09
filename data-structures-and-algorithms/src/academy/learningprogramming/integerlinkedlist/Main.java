package academy.learningprogramming.integerlinkedlist;

/**
*
* brunolima on Feb 8, 2021
* 
*/

public class Main {
	
	public static void main(String[] args) {
		Integer one = 1;
		Integer two = 2;
		Integer three = 3;
		Integer four = 4;
		
		InterLinkedList list = new InterLinkedList();
		list.insertSorted(three);
		list.printList();
		list.insertSorted(two);
		list.printList();
		list.insertSorted(one);
		list.printList();
		list.insertSorted(four);
		list.printList();
	}

}

