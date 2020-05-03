package br.com.deitel.cap.three;

import java.util.Scanner;

public class GradeBook3Test {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		GradeBook3 gradeBook3 = new GradeBook3();
		
		System.out.printf("Initial course name is: %s\n\n", gradeBook3.getCourseName());
		
		System.out.println("Please enter the course name: ");
		String nameCourse = input.nextLine();
		gradeBook3.setCourseName(nameCourse);
		System.out.println();
		
		gradeBook3.displayMessage();
	}
}
