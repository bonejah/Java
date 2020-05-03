package br.com.deitel.cap.three;

public class GradeBook {
	private String teacherName;
	private String courseName;

	public GradeBook(String courseName, String teacherName) {
		this.teacherName = teacherName;
		this.courseName = courseName;
	}

	public String getTeacherName() {
		return teacherName;
	}

	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public void displayMessage() {
		System.out.println(
				"Welcome to the GradeBook!\nThis course " + getCourseName() + " is presented by: " + getTeacherName());
	}
}
