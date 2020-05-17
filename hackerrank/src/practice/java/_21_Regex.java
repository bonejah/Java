package practice.java;

import java.util.Scanner;

public class _21_Regex {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		while (in.hasNext()) {
			String IP = in.next();
			new MyRegex();
			System.out.println(IP.matches(MyRegex.pattern));
		}
		
		in.close();
	}
}

class MyRegex {
	static final String pattern = "^([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." + "([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\."
			+ "([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." + "([01]?\\d\\d?|2[0-4]\\d|25[0-5])$";
}
