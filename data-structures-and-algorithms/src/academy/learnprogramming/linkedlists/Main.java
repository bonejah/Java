package academy.learnprogramming.linkedlists;

/**
 *
 * brunolima on Feb 7, 2021
 * 
 */

public class Main {

	public static void main(String[] args) {
		Employee janeJones = new Employee("Jane", "Jones", 123);
		Employee johnDoe = new Employee("John", "Doe", 4567);
		Employee marySmith = new Employee("Mary", "Smith", 22);
		Employee mikeWilson = new Employee("Mike", "Wilson", 323);
		
		EmployeeLinkedList list = new EmployeeLinkedList();
		System.out.println("List is empty: " + list.isEmpty());
		
		list.addFront(janeJones);
		list.addFront(johnDoe);
		list.addFront(marySmith);
		list.addFront(mikeWilson);
		
		System.out.println("List is empty: " + list.isEmpty());
		
		list.printList();
		
		System.out.println("The size is: " + list.getSize());
		
		list.removeFromFront();
		
		list.printList();
		
	}

}
