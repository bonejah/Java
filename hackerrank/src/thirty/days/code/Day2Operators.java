package thirty.days.code;

import java.util.Scanner;

public class Day2Operators {

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		double meal_cost = scanner.nextDouble();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		int tip_percent = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		int tax_percent = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		solve(meal_cost, tip_percent, tax_percent);

		scanner.close();
	}

	// Complete the solve function below.
	static void solve(double mealCost, int tipPercent, int taxPercent) {
		double tip = mealCost * (new Double(tipPercent) / 100);
		double tax = mealCost * (new Double(taxPercent) / 100);
		System.out.println(Math.round(mealCost + tip + tax));
	}

}
