package br.com.deitel.cap.three;

public class InvoiceTest {
	public static void main(String[] args) {
		Invoice invoice = new Invoice("123456", "Invoice 1", 10, 7.55);
		System.out.println("Total invoice: " + invoice.getInvoiceAmount());
	}
}
