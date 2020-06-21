package practice.java;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.security.Permission;

public class _61_CanYouAccess {

	public static void main(String[] args) throws Exception {
		DoNotTerminate.forbidExit();

		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			int num = Integer.parseInt(br.readLine().trim());

			Object o;

			if (num < 1 || num > Math.pow(2, 30))
				throw new Exception();

			_61_CanYouAccess.Inner ob = new _61_CanYouAccess.Inner();
			Class<?> c = _61_CanYouAccess.Inner.class.getDeclaredClasses()[0];
			Constructor<?> constructor = c.getDeclaredConstructor(_61_CanYouAccess.Inner.class);
			constructor.setAccessible(true);
			o = constructor.newInstance(ob);
			Method m = c.getDeclaredMethod("powerof2", new Class[] { int.class });
			m.setAccessible(true);
			String ans = (String) m.invoke(o, num);
			System.out.println(num + " is " + ans);
			
			System.out.println("An instance of class: " + o.getClass().getCanonicalName() + " has been created");
		} // end of try

		catch (DoNotTerminate2.ExitTrappedException e) {
			System.out.println("Unsuccessful Termination!!");
		}
	}// end of main

	static class Inner {
		private class Private {
			private String powerof2(int num) {
				return ((num & num - 1) == 0) ? "power of 2" : "not a power of 2";
			}
		}
	}// end of Inner

}

class DoNotTerminate2 { // This class prevents exit(0)

	public static class ExitTrappedException extends SecurityException {

		private static final long serialVersionUID = 1L;
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
