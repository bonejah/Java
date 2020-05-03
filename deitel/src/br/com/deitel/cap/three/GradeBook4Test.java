package br.com.deitel.cap.three;

public class GradeBook4Test {
	public static void main(String[] args) {
		GradeBook4 gradeBook1 = new GradeBook4("Ruby on Rails");
		GradeBook4 gradeBook2 = new GradeBook4("Python");
		
		System.out.printf(" gradebook1 course name is: %s\n", gradeBook1.getCourseName());
		System.out.printf(" gradebook2 course name is: %s\n", gradeBook2.getCourseName());
	}
}
