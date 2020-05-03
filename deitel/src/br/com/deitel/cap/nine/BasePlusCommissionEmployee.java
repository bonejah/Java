package br.com.deitel.cap.nine;

public class BasePlusCommissionEmployee {
	private String firstName;
	private String lastName;
	private String sociaSecurityNumber;
	private double grossSales;
	private double commissionRate;
	private double baseSalary;

	public BasePlusCommissionEmployee(String firstName, String lastName, String sociaSecurityNumber, double grossSales,
			double commissionRate, double baseSalary) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.sociaSecurityNumber = sociaSecurityNumber;
		setGrossSales(grossSales);
		setCommissionRate(commissionRate);
		setBaseSalary(baseSalary);
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

	public void setSociaSecurityNumber(String sociaSecurityNumber) {
		this.sociaSecurityNumber = sociaSecurityNumber;
	}

	public String getSociaSecurityNumber() {
		return sociaSecurityNumber;
	}

	public void setGrossSales(double grossSales) {
		this.grossSales = (grossSales < 0.0) ? 0.0 : grossSales;
	}

	public double getGrossSales() {
		return grossSales;
	}

	public void setCommissionRate(double commissionRate) {
		this.commissionRate = (commissionRate > 0.0 && commissionRate < 1.0) ? commissionRate : 0.0;
	}

	public double getCommissionRate() {
		return commissionRate;
	}

	public void setBaseSalary(double baseSalary) {
		this.baseSalary = (baseSalary < 0.0) ? 0.0 : baseSalary;
	}

	public double getBaseSalary() {
		return baseSalary;
	}

	public double earnings() {
		return baseSalary + (commissionRate * grossSales);
	}

	@Override
	public String toString() {
		return String.format("%s: %s %s\n%s: %s\n%s: %.2f\n%s: %.2f\n%s: %.2f ", "base-salaried commission employee",
				firstName, lastName, "social security number", sociaSecurityNumber, "gross sales", grossSales,
				"commission rate", commissionRate, "base salary", baseSalary);
	}

}
