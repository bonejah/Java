package practice.java;

import java.util.Scanner;

public class _10_StaticInitializerBLock {
	static boolean flag = false;
	static Scanner scanner = new Scanner(System.in);
	static int B;
	static int H;

	static {
		B = scanner.nextInt();
		H = scanner.nextInt();

		if (B > 0 && H > 0) {
			flag = true;
		} else {
			System.out.println("java.lang.Exception: Breadth and height must be positive");
		}

	}

	@SuppressWarnings("resource")
	public static void main(String[] args) throws Exception {
		if (flag) {
			int area = B * H;
			System.out.print(area);
		}
	}

}
