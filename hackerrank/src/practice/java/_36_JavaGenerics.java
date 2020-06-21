package practice.java;

import java.lang.reflect.Method;

public class _36_JavaGenerics {

	public static void main(String args[]) {
		Integer[] intArray = { 1, 2, 3 };
		String[] stringArray = { "Hello", "World" };

		Printer myPrinter = new Printer();
		myPrinter.printArray(intArray);
		myPrinter.printArray(stringArray);

		int count = 0;

		for (Method method : Printer.class.getDeclaredMethods()) {
			String name = method.getName();
			if (name.equals("printArray"))
				count++;
		}

		if (count > 1)
			System.out.println("Method overloading is not allowed!");
	}

}

class Printer {

	public void printArray(Object[] intArray) {
		for (Object object : intArray) {
			System.out.println(object);
		}
	}

}