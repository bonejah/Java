package br.com.deitel.cap.nine;

public class BasePlusCommissionEmployeeII extends CommissionEmployee {
	private double baseSalary;

	public BasePlusCommissionEmployeeII(String first, String last, String ssn, double sales, double rate,
			double salary) {
		super(first, last, ssn, sales, rate);
		setBaseSalary(salary);
	}

	public void setBaseSalary(double baseSalary) {
		this.baseSalary = (baseSalary < 0.0) ? 0.0 : baseSalary;
	}

	public double getBaseSalary() {
		return baseSalary;
	}

	@Override
	public double earnings() {
		return getBaseSalary() + super.earnings();
	}

	@Override
	public String toString() {
		return String.format("%s %s\n%s: %.2f", "base-salaried", super.toString(), "base salary", getBaseSalary());
	}
}
