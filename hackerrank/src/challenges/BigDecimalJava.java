package challenges;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class BigDecimalJava {

	public static void main(String[] args) {
		// Input
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		String[] arrayValues = new String[n + 2];

		for (int i = 0; i < n; i++) {
			arrayValues[i] = sc.next();
		}

		sc.close();

		// Write your code here
		Arrays.sort(arrayValues, 0, n, Collections.reverseOrder(new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				BigDecimal value1 = new BigDecimal(o1);
				BigDecimal value2 = new BigDecimal(o2);
				return value1.compareTo(value2);
			}
		}));
		
		// Output
		for (int i = 0; i < n; i++) {
			System.out.println(arrayValues[i]);
		}
	}

}
