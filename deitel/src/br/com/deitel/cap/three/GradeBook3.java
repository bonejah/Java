package br.com.deitel.cap.three;

public class GradeBook3 {
	private String courseName;

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public void displayMessage() {
		System.out.printf("Welcome to the GradeBook for \n%s!\n", getCourseName());
	}
}
