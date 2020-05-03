package br.com.deitel.cap.seven;

public class GradeBookUsingArrayTest {
	public static void main(String[] args) {
		int[][] gradesArray = { { 87, 96, 50 }, { 68, 87, 90 }, { 94, 100, 90 }, { 100, 81, 82 }, { 83, 65, 85 },
				{ 78, 87, 65 }, { 85, 75, 83 }, { 91, 94, 100 }, { 76, 72, 84 }, { 87, 93, 73 } };
		
		GradeBookUsingArray gradeBookUsingArray = new GradeBookUsingArray("Java Programming", gradesArray);
		gradeBookUsingArray.displayMessage();
		gradeBookUsingArray.processGrades();
	}
}
