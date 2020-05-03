package br.com.deitel.cap.nine;

public class CommissionEmployeeTest {
	public static void main(String[] args) {
		CommissionEmployee employee = new CommissionEmployee("Sue", "Jone", "222-22-2222", 10000, .06);
		
		System.out.println("Employee information obtained by get methods: \n");
		System.out.printf("%s %s\n", "First name is", employee.getFirstName());
		System.out.printf("%s %s\n", "Last name is", employee.getLastName());
		System.out.printf("%s %s\n", "Social Security number is", employee.getSocialSecurityNumber());
		System.out.printf("%s %s\n", "Gross sales is", employee.getGrossSales());
		System.out.printf("%s %s\n", "Commission rate is", employee.getComissionRate());
		
		employee.setGrossSales(500);
		employee.setComissionRate(.1);
		
		System.out.printf("\n%s: \n\n%s\n", "Updated employee information obtained by toString", employee);
	}
}
