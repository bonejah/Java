package br.com.deitel.cap.three;

import java.util.Scanner;

public class GradeBook2Test {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		GradeBook2 gradeBook2 = new GradeBook2();
		
		System.out.println("Please enter the course name: ");
		String nameCourse = input.nextLine();
		System.out.println();
		
		gradeBook2.displayMessage(nameCourse);
	}
}
