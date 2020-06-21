package practice.java;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class _50_JavaMD5 {
	
	public static void main(String[] args) throws NoSuchAlgorithmException {
		Scanner scanner = new Scanner(System.in);

		String s = scanner.next();
		byte[] md = MessageDigest.getInstance("SHA-256").digest(s.getBytes());
		
		for (int i = 0; i < md.length; i++) {
			System.out.printf("%02x", md[i]);
		}
		
		scanner.close();
	}

}
