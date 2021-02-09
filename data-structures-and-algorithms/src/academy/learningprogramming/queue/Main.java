package academy.learningprogramming.queue;


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
		
		ArrayQueue queue = new ArrayQueue(10);
		queue.add(janeJones);
		queue.add(johnDoe);
		queue.add(marySmith);
		queue.add(mikeWilson);
		queue.add(billEnd);
		queue.printQueue();
		
		queue.remove();
		queue.remove();
		queue.printQueue();
	}

}

