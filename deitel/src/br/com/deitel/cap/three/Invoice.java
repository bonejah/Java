package br.com.deitel.cap.three;

public class Invoice {
	private String numberInvoice;
	private String description;
	private int quantity;
	private double price;

	public Invoice(String numberInvoice, String description, int quantity, double price) {
		super();
		this.numberInvoice = numberInvoice;
		this.description = description;
		this.quantity = quantity;
		this.price = price;
	}

	public String getNumberInvoice() {
		return numberInvoice;
	}

	public void setNumberInvoice(String numberInvoice) {
		this.numberInvoice = numberInvoice;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	public double getInvoiceAmount() {
		double total = quantity * price;
		
		if (total == 0)
			return 0.0;
		
		return total;
	}	
}
