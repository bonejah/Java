package thirty.days.code;

import java.util.Scanner;

class Persons {
	protected String firstName;
	protected String lastName;
	protected int idNumber;
	
	// Constructor
	Persons(String firstName, String lastName, int identification){
		this.firstName = firstName;
		this.lastName = lastName;
		this.idNumber = identification;
	}
	
	// Print person data
	public void printPerson(){
		 System.out.println(
				"Name: " + lastName + ", " + firstName 
			+ 	"\nID: " + idNumber); 
	}
	 
}

class Student extends Persons {
	private int[] testScores;

	public Student(String firstName, String lastName, int id, int[] scores) {
		super(firstName, lastName, id);
		testScores = scores;
	}

	public String calculate() {
		
		int totalScores = testScores.length;
		int sumScores = 0;
		
		for (int i = 0; i < testScores.length; i++) {
			sumScores += testScores[i];
		}
		
		int average = sumScores / totalScores;
		
		if (average >= 90 && average <= 100) {
			return "O";
		} else if (average >= 80 && average < 90) {
			return "E";
		} else if (average >= 70 && average <= 80) {
			return "A";
		} else if (average >= 55 && average < 70 ) {
			return "P";
		} else if (average >= 40 && average < 55) {
			return "D";
		} else if (average < 40) {
			return "T";
		}
		
		return null;
		
	}
}

public class Day12Inheritance {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String firstName = scan.next();
		String lastName = scan.next();
		int id = scan.nextInt();
		int numScores = scan.nextInt();
		int[] testScores = new int[numScores];
		
		for (int i = 0; i < numScores; i++) {
			testScores[i] = scan.nextInt();
		}
		scan.close();

		Student s = new Student(firstName, lastName, id, testScores);
		s.printPerson();
		System.out.println("Grade: " + s.calculate());
	}
}

