package practice.java;

import java.security.Permission;
import java.util.Scanner;

public class _11_JavaIntToString {

	public static void main(String[] args) {
		DoNotTerminate2.forbidExit();

		try {
			Scanner in = new Scanner(System.in);
			int n = in.nextInt();
			in.close();

			String s = Integer.toString(n);

			if (n <= 100 && n >= -100) {
				if (n == Integer.parseInt(s)) {
					System.out.println("Good job");
				} else {
					System.out.println("Wrong answer.");
				}
			} else {
				System.out.println("Wrong answer.");
			}
		} catch (DoNotTerminate2.ExitTrappedException e) {
			System.out.println("Unsuccessful Termination!!");
		}
	}

}

class DoNotTerminate {

	public static class ExitTrappedException extends SecurityException {
		private static final long serialVersionUID = 1;
	}

	public static void forbidExit() {
		final SecurityManager securityManager = new SecurityManager() {
			@Override
			public void checkPermission(Permission permission) {
				if (permission.getName().contains("exitVM")) {
					throw new ExitTrappedException();
				}
			}
		};
		System.setSecurityManager(securityManager);
	}
	
}