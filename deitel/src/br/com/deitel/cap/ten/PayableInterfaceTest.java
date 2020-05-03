package br.com.deitel.cap.ten;

public class PayableInterfaceTest {
	public static void main(String[] args) {
		Payable[] payables = new Payable[4];

		payables[0] = new Invoice("01234", "seat", 2, 375.00);
		payables[1] = new Invoice("56789", "tire", 4, 79.95);
		payables[2] = new SalariedEmployee("John", "Smith", "222-22-2222", 800.00);
		payables[3] = new SalariedEmployee("Lisa", "Barnes", "333-33-3333", 1200.00);

		System.out.println("Invoices and Employees processed polymorphically:\n");

		for (Payable payable : payables) {
			System.out.printf("%s \n%s: $%,.2f\n\n", payable.toString(), "payment due", payable.getPaymentAmount());
		}
	}
}
