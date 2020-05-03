package br.com.deitel.cap.eight;

public class EmployeeIITest {
	public static void main(String[] args) {
		System.out.printf("Employees before instantiation: %d\n", EmployeeII.getCount());

		EmployeeII employee1 = new EmployeeII("Susan", "Baker");
		EmployeeII employee2 = new EmployeeII("Bob", "Blue");

		System.out.println("\nEmployee after instantiation: ");
		System.out.printf("via e1.getCount: %d\n", employee1.getCount());
		System.out.printf("via e2.getCount: %d\n", employee2.getCount());
		System.out.printf("via Employee.getCount(): %d\n", EmployeeII.getCount());

		System.out.printf("\nEmployee 1: %s %s\nEmployee 1: %s %s\n", employee1.getFirstName(), employee1.getLastName(),
				employee2.getFirstName(), employee2.getLastName());
		
		employee1 = null;
		employee2 = null;
	}
}
