package br.com.deitel.cap.twenty.one;

import java.util.ArrayList;

import br.com.deitel.cap.five.Sum;

public class TotalNumbers {
	public static void main(String[] args) {
		Number[] numbers = { 1, 2.4, 3, 4.1 };
		ArrayList<Number> numberList = new ArrayList<Number>();

		for (Number element : numbers) {
			numberList.add(element);
		}

		System.out.printf("numberList contains: %s\n", numberList);
		System.out.printf("Total of the elements in numberList: %.1f\n", sum(numberList));
	}

	private static double sum(ArrayList<Number> list) {
		double total = 0;

		for (Number element : list) {
			total += element.doubleValue();
		}

		return total;
	}
}
