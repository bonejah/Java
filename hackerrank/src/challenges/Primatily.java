package challenges;

import java.math.BigInteger;
import java.util.Scanner;

public class Primatily {

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		String n = scanner.nextLine();
		System.out.println(new BigInteger(n).isProbablePrime(1) == true ? "prime" : "not prime");
		scanner.close();
	}

}
