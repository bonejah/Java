package br.com.deitel.cap.eight;

public class Employee {
	private String firstName;
	private String lastName;
	private Date birthDate;
	private Date hireDate;

	public Employee(String firstName, String lastName, Date birthDate, Date hireDate) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthDate = birthDate;
		this.hireDate = hireDate;
	}

	@Override
	public String toString() {
		return String.format("%s, %s Hired: %s BirthDay: %s", lastName, firstName, hireDate, birthDate);
	}
}
