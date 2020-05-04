package thirty.days.code;

import java.util.Scanner;

public class Day20Sorting {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] a = new int[n];
		int countSwaps = 0;

		if (n < 2 && n >= 600) {
			printResult(a, countSwaps);
		} else {
			for (int a_i = 0; a_i < n; a_i++) {
				a[a_i] = in.nextInt();
			}

			for (int i = 0; i < n; i++) {

				for (int j = 0; j < n - 1; j++) {

					if (a[j] > a[j + 1]) {
						int swap = a[j];
						a[j] = a[j + 1];
						a[j + 1] = swap;
						countSwaps++;
					}
				}

			}

			printResult(a, countSwaps);
		}
	}

	private static void printResult(int[] a, int countSwaps) {
		System.out.println("Array is sorted in " + countSwaps + " swaps.");
		System.out.println("First Element: " + a[0]);
		System.out.println("Last Element: " + a[a.length - 1]);
	}

}
