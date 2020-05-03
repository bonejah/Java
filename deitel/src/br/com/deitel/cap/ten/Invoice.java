package br.com.deitel.cap.ten;

public class Invoice implements Payable {
	private String partNumber;
	private String partDescription;
	private int quantity;
	private double priceItem;

	public Invoice(String partNumber, String partDescription, int quantity, double priceItem) {
		this.partNumber = partNumber;
		this.partDescription = partDescription;
		setQuantity(quantity);
		setPriceItem(priceItem);
	}

	public String getPartNumber() {
		return partNumber;
	}

	public void setPartNumber(String partNumber) {
		this.partNumber = partNumber;
	}

	public String getPartDescription() {
		return partDescription;
	}

	public void setPartDescription(String partDescription) {
		this.partDescription = partDescription;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = (quantity < 0) ? 0 : quantity;
	}

	public double getPriceItem() {
		return priceItem;
	}

	public void setPriceItem(double priceItem) {
		this.priceItem = (priceItem < 0.0) ? 0.0 : priceItem;
	}

	@Override
	public String toString() {
		return String.format("%s: \n%s: %s (%s) \n%s: %d \n%s: $%,.2f", "Invoice", "part number", getPartNumber(),
				getPartDescription(), "quantity", getQuantity(), "price per item", getPriceItem());
	}

	@Override
	public double getPaymentAmount() {
		return getQuantity() * getPriceItem();
	}
}
