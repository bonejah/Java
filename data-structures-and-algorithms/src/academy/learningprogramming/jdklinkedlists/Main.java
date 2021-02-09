package academy.learningprogramming.jdklinkedlists;

import java.util.Iterator;
import java.util.LinkedList;

/**
*
* brunolima on Feb 8, 2021
* 
*/

public class Main {
	
	public static void main(String[] args) {
		Employee janeJones = new Employee("Jane", "Jones", 123);
		Employee johnDoe = new Employee("John", "Doe", 4567);
		Employee marySmith = new Employee("Mary", "Smith", 22);
		Employee mikeWilson = new Employee("Mike", "Wilson", 323);
		Employee billEnd = new Employee("Bill", "End", 12123);
		
		LinkedList<Employee> linkedList = new LinkedList<>();
		
		linkedList.addFirst(janeJones);
		linkedList.addFirst(johnDoe);
		linkedList.addFirst(marySmith);
		linkedList.addFirst(mikeWilson);
		printLinkedList(linkedList);
		
		linkedList.add(billEnd);
		printLinkedList(linkedList);
		
		linkedList.removeFirst();
		printLinkedList(linkedList);
		
		linkedList.removeLast();
		printLinkedList(linkedList);
	}

	private static void printLinkedList(LinkedList<Employee> linkedList) {
		Iterator<Employee> it = linkedList.iterator();
		System.out.print("HEAD -> ");
		while(it.hasNext()) {
			System.out.print(it.next().getFirstName());
			System.out.print(" <=> ");
		}
		System.out.print(" null\n\n");
	}

}

