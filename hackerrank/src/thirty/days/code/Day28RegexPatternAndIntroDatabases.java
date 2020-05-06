package thirty.days.code;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Day28RegexPatternAndIntroDatabases {

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		int N = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
		
		List<PersonX> lsPerson = new ArrayList<PersonX>();

		for (int NItr = 0; NItr < N; NItr++) {
			String[] firstNameEmailID = scanner.nextLine().split(" ");
			String firstName = firstNameEmailID[0];
			String emailID = firstNameEmailID[1];
			
			
			if (emailID.contains("@gmail.com")) {
				PersonX p = new PersonX(firstName, emailID);
				lsPerson.add(p);
			}
		}
		
		Collections.sort(lsPerson);
		
		for (PersonX personX : lsPerson) {
			System.out.println(personX.firstName);
		}

		scanner.close();
	}

}

class PersonX implements Comparable<PersonX> {
	String firstName;
	String email;

	public PersonX(String firstName, String email) {
		this.firstName = firstName;
		this.email = email;
	}

	@Override
	public String toString() {
		return "Person [firstName=" + firstName + ", email=" + email + "]";
	}

	@Override
	public int compareTo(PersonX person) {
		return this.firstName.compareTo(person.firstName);
	}

}