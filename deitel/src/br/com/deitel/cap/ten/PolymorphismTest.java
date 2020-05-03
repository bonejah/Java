package br.com.deitel.cap.ten;

import br.com.deitel.cap.nine.BasePlusCommissionEmployeeII;
import br.com.deitel.cap.nine.CommissionEmployee;

public class PolymorphismTest {
	public static void main(String[] args) {
		CommissionEmployee commissionEmployee = new CommissionEmployee("Sue", "Bob", "222-22-2222", 10000, .06);
		BasePlusCommissionEmployeeII basePlusCommissionEmployee = new BasePlusCommissionEmployeeII("Bob", "Lewie",
				"333-33-3333", 5000, .04, 300);

		System.out.printf("%s %s:\n\n%s\n\n", "Call CommissionEmployee's toString with superclass reference ",
				"to superclass Object", commissionEmployee.toString());

		System.out.printf("%s %s:\n\n%s\n\n", "Call BasePlusCommissionEmployeeII's toString with subclas reference ",
				"to superclass Object", basePlusCommissionEmployee.toString());

		CommissionEmployee commissionEmployee2 = basePlusCommissionEmployee;
		System.out.printf("%s %s:\n\n%s\n\n", "Call BasePlusCommissionEmployeeII's toString with subclas reference ",
				"to superclass Object", commissionEmployee2.toString());
	}
}
