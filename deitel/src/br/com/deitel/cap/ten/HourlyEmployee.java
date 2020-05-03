package br.com.deitel.cap.ten;

public class HourlyEmployee extends Employee {
	private double wage;
	private double hours;

	public HourlyEmployee(String first, String last, String ssn, double hourlyWage, double hoursWorked) {
		super(first, last, ssn);
		setWage(hourlyWage);
		setHours(hoursWorked);
	}

	public double getWage() {
		return wage;
	}

	public void setWage(double wage) {
		this.wage = wage < 0.0 ? 0.0 : wage;
	}

	public double getHours() {
		return hours;
	}

	public void setHours(double hours) {
		this.hours = ((hours >= 0.0) && (hours <= 168.0)) ? hours : 0.0;
	}

	@Override
	public double earnings() {
		if (getHours() <= 40)
			return getWage() * getHours();
		else
			return 40 * getWage() + (getHours() - 40) * getWage() * 1.5;
	}

	@Override
	public String toString() {
		return String.format("hourly employee: %s\n%s: $%,.2f; %s: %,.2f", super.toString(), "hourly wage", getWage(),
				"hours worked", getHours());
	}

	@Override
	public double getPaymentAmount() {
		return getWage();
	}
}
