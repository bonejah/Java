package br.com.deitel.cap.five;

public class GradeBookTest {
	public static void main(String[] args) {
		GradeBook gradeBook = new GradeBook("Java");
		gradeBook.displayMessage();
		gradeBook.inputGrades();
		gradeBook.displayGradeReport();
	}
}
