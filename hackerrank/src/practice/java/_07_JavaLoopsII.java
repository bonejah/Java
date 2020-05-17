package practice.java;

import java.util.Scanner;

public class _07_JavaLoopsII {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		
		for (int i = 0; i < t; i++) {
			int a = in.nextInt();
			int b = in.nextInt();
			int n = in.nextInt();

//			for (int j = 0; j < n; j++) {
//				a += b;
//				if (j > 0)
//					System.out.print(" ");
//				System.out.print(a);
//				b = b * 2;
//			}

			for (int j = 0; j < n; j++) {
				a = a + (int) Math.pow(2, j) * b;

				if (j > 0)
					System.out.print(" ");
				System.out.print(a);
			}
			
			System.out.println();
		}

		in.close();
	}
	
}
