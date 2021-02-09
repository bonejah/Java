package academy.learnprogramming.linkedlists;

/**
*
* brunolima on Feb 7, 2021
* 
*/

public class EmployeeLinkedList {
	
	private EmployeeNode head;
	private int size;
	
	public void addFront(Employee employee) {
		EmployeeNode node = new EmployeeNode(employee);
		node.setNext(head);
		head = node;
		size++;
	}
	
	public EmployeeNode removeFromFront() {
		if (isEmpty()) {
			return null;
		}
		
		EmployeeNode removedNode = head;
		head = head.getNext();
		size--;
		removedNode.setNext(null);
		return removedNode;
	}
	
	public void printList() {
		EmployeeNode current = head;
		System.out.print("HEAD -> ");
		
		while(current != null) {
			System.out.print(current.getEmployee().getFullName());
			System.out.print(" -> ");
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

