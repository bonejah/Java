package br.com.deitel.cap.three;

public class GradeBook4 {
	private String courseName;
	
	public GradeBook4(String name) {
		this.courseName =  name;
	}

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
