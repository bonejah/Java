package br.com.deitel.cap.nine;

public class BasePlusCommissionEmployeeTest {
	public static void main(String[] args) {
		BasePlusCommissionEmployee employee = new BasePlusCommissionEmployee("Bob", "Lewis",
				"333-33-3333", 5000, .04, 400);

		System.out.println("Employee information obtained by get methods: \n");
		System.out.printf("%s %s\n", "First name is", employee.getFirstName());
		System.out.printf("%s %s\n", "Last name is", employee.getLastName());
		System.out.printf("%s %s\n", "Social Security number is", employee.getSociaSecurityNumber());
		System.out.printf("%s %s\n", "Gross Sales is", employee.getGrossSales());
		System.out.printf("%s %s\n", "Commission rate is", employee.getCommissionRate());
		System.out.printf("%s %s\n", "Base salary is", employee.getBaseSalary());
		
		employee.setBaseSalary(1000);
		System.out.printf("\n%s: \n\n%s\n", "Update employee information obtained by toString", employee.toString());

	}
}
