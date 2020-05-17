package practice.java;

import java.util.Scanner;

public class _02_JavaStdinAndStdoutI {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int int1 = sc.nextInt();
		int int2 = sc.nextInt();
		int int3 = sc.nextInt();
		
		System.out.println(int1);
		System.out.println(int2);
		System.out.println(int3);
		
		sc.close();
	}

}
