package academy.learnprogramming.linkedlists;

/**
 *
 * brunolima on Feb 7, 2021
 * 
 */

public class EmployeeNode {

	private Employee employee;
	private EmployeeNode next;

	public EmployeeNode(Employee employee) {
		this.employee = employee;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public EmployeeNode getNext() {
		return next;
	}

	public void setNext(EmployeeNode next) {
		this.next = next;
	}

}
