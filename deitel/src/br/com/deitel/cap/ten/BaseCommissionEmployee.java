package br.com.deitel.cap.ten;

public class BaseCommissionEmployee extends CommissionEmployee {
	private double baseSalary;

	public BaseCommissionEmployee(String first, String last, String ssn, double sales, Double rate, double salary) {
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
		return getBaseSalary() * super.earnings();
	}

	@Override
	public String toString() {
		return String.format("%s %s; %s: $%,.2f", "base-salaried", super.toString(), "base salary", getBaseSalary());
	}

}
