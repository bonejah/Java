package academy.learningprogramming.doublelinkedlists;

/**
*
* brunolima on Feb 7, 2021
* 
*/

public class EmployeeDoubleLinkedList {
	
	private EmployeeNode head;
	private EmployeeNode tail;
	private int size;
	
	public void addFront(Employee employee) {
		EmployeeNode node = new EmployeeNode(employee);
		
		if (head == null) {
			tail = node;
		} else {
			head.setPrevious(node);
			node.setNext(head);
		}
		
		head = node;
		size++;
	}
	
	public void addToEnd(Employee employee) {
		EmployeeNode node = new EmployeeNode(employee);
		
		if (tail == null) {
			head = node;
		} else {
			tail.setNext(node);
			node.setPrevious(tail);
		}
		
		tail = node;
		size++;
	}
	
	public EmployeeNode removeFromFront() {
		if (isEmpty()) return null;
		
		EmployeeNode removedNode = head;
		
		if (head.getNext() == null) {
			tail = null;
		} else {
			head.getNext().setPrevious(null);
		}
		
		head = head.getNext();
		size--;
		removedNode.setNext(null);
		return removedNode;
	}
	
	public EmployeeNode removeFromEnd() {
		if (isEmpty()) return null;
		
		EmployeeNode removedNode = tail;
		
		if (tail.getPrevious() == null) {
			head = null;
		} else {
			tail.getPrevious().setNext(null);
		}
		
		tail = tail.getPrevious();
		size--;
		removedNode.setPrevious(null);
		return removedNode;
	}
	
	public boolean addBefore(Employee newEmployee, Employee existingEmployee) {
		if (isEmpty()) return false;
		
		EmployeeNode current = head;
		while(current != null && !current.getEmployee().equals(existingEmployee)) {
			current = current.getNext();
		}
	
		if (current == null) return false;
		
		EmployeeNode newNode = new EmployeeNode(newEmployee);
		newNode.setPrevious(current.getPrevious());
		newNode.setNext(current);
		current.setPrevious(newNode);
		
		if (head == current) {
			head = newNode;
		} else {
			newNode.getPrevious().setNext(newNode);
		}
		
		size++;
 		
		return true;
	}
	
	public void printList() {
		EmployeeNode current = head;
		System.out.print("HEAD -> ");
		
		while(current != null) {
			System.out.print(current.getEmployee().getFullName());
			System.out.print(" <=> ");
			current = current.getNext();
		}
		
		System.out.println("null");
	}

	public int getSize() {
		return size;
	}
	
	public boolean isEmpty() {
		return head == null;
	}
}

