package br.com.deitel.cap.ten;

public class SalariedEmployee extends Employee {
	private double weeklySalary;

	public SalariedEmployee(String first, String last, String ssn, double salary) {
		super(first, last, ssn);
		setWeeklySalary(salary);
	}

	public void setWeeklySalary(double weeklySalary) {
		this.weeklySalary = weeklySalary < 0.0 ? 0.0 : weeklySalary;
	}

	public double getWeeklySalary() {
		return weeklySalary;
	}

	@Override
	public double earnings() {
		return getWeeklySalary();
	}

	@Override
	public String toString() {
		return String.format("salaried employee: %s\n%s:  $%,.2f", super.toString(), "weekly salary",
				getWeeklySalary());
	}

	@Override
	public double getPaymentAmount() {
		return getWeeklySalary();
	}
}
