package practice.java;

import java.security.Permission;
import java.util.Scanner;

public class _63_JavaFactoryPattern {

	public static void main(String args[]) {
		Do_Not_Terminate.forbidExit();
		Scanner sc = new Scanner(System.in);

		try {

			// creating the factory
			FoodFactory foodFactory = new FoodFactory();

			// factory instantiates an object
			Food food = foodFactory.getFood(sc.nextLine());

			System.out.println("The factory returned " + food.getClass());
			System.out.println(food.getType());
		} catch (Do_Not_Terminate.ExitTrappedException e) {
			System.out.println("Unsuccessful Termination!!");
		} 
		
		sc.close();
		
	}

}

class Do_Not_Terminate {

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

interface Food {
	public String getType();
}

class Pizza implements Food {
	public String getType() {
		return "Someone ordered a Fast Food!";
	}
}

class Cake implements Food {

	public String getType() {
		return "Someone ordered a Dessert!";
	}
}

class FoodFactory {
	public Food getFood(String order) {
		Food food = null;
		
		if ("pizza".equals(order))
			food = new Pizza();
		else if ("cake".equals(order))
			food = new Cake();
		return food;
	}

}// End of getFood method