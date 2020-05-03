package br.com.deitel.cap.four;

import java.util.Scanner;

public class GradeBook {
	private String courseName;
	
	public GradeBook(String name) {
		courseName = name;
	}
	
	public String getCourseName() {
		return courseName;
	}
	
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	
	public void displayMessage() {
		System.out.printf("Welcome to the GradeBook for\n%s!\n\n", getCourseName());
	}
	
	public void determineClassAverage() {
		 Scanner input = new Scanner(System.in);
		 
		  int total;
		  int gradeCounter;
		  int grade;
		  int average;
		  
		  total = 0;
		  gradeCounter = 1;
		  
		  while (gradeCounter <= 10) {
			  System.out.print("Enter grade: ");
			  grade = input.nextInt();
			  total = total + grade;
			  gradeCounter = gradeCounter + 1;
		  }
		  
		  average = total / 10;
		  
		  System.out.printf("\nTotal of all 10 grades is %d\n", total);
		  System.out.printf("Class average is %d\n", average);
	}
}
