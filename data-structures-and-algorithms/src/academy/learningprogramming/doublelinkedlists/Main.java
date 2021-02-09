package academy.learningprogramming.doublelinkedlists;

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
		Employee brunoLima = new Employee("Bruno", "Lima", 7);
		
		
		EmployeeDoubleLinkedList linkedList = new EmployeeDoubleLinkedList();
		linkedList.addFront(janeJones);
		linkedList.addFront(johnDoe);
		linkedList.addFront(marySmith);
		linkedList.addFront(mikeWilson);
		
		linkedList.printList();
		System.out.println(linkedList.getSize());
		
		Employee billEnd = new Employee("Bill", "End", 78);
		linkedList.addToEnd(billEnd);
		
		linkedList.printList();
		System.out.println(linkedList.getSize());
		
		linkedList.removeFromFront();
		
		linkedList.printList();
		System.out.println(linkedList.getSize());
		
		linkedList.removeFromEnd();
		
		linkedList.printList();
		System.out.println(linkedList.getSize());
		
		linkedList.addBefore(brunoLima, marySmith);
		linkedList.printList();
		System.out.println(linkedList.getSize());
	}

}
