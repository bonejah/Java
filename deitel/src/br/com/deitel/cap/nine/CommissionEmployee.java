package br.com.deitel.cap.nine;

public class CommissionEmployee {
	private String firstName;
	private String lastName;
	private String socialSecurityNumber;
	private double grossSales;
	private double comissionRate;

	public CommissionEmployee(String firstName, String lastName, String socialSecurityNumber, double grossSales,
			double comissionRate) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.socialSecurityNumber = socialSecurityNumber;
		setGrossSales(grossSales);
		setComissionRate(comissionRate);
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setSocialSecurityNumber(String ssn) {
		socialSecurityNumber = ssn;
	}

	public String getSocialSecurityNumber() {
		return socialSecurityNumber;
	}

	public void setGrossSales(double grossSales) {
		this.grossSales = (grossSales < 0.0) ? 0.0 : grossSales;
	}

	public double getGrossSales() {
		return grossSales;
	}

	public void setComissionRate(double comissionRate) {
		this.comissionRate = (comissionRate > 0.0 && comissionRate < 1.0) ? comissionRate : 0.0;
	}

	public double getComissionRate() {
		return comissionRate;
	}

	public double earnings() {
		return getComissionRate() * getGrossSales();
	}

	@Override
	public String toString() {
		return String.format("%s: %s %s\n%s: %s\n%s: %.2f\n%s: %.2f", "commission employee", getFirstName(),
				getLastName(), "social security number", getSocialSecurityNumber(), "gross sales", getGrossSales(),
				"commission rate", getComissionRate());
	}
}
