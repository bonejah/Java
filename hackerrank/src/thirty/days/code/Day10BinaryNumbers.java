package thirty.days.code;

import java.util.Arrays;
import java.util.Scanner;

public class Day10BinaryNumbers {

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		int n = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
		
		System.out.println("Val num: " + n);
		System.out.println(Integer.toBinaryString(n));
		String[] split = Integer.toBinaryString(n).split("0+");	
		Arrays.sort(split);
		System.out.println(split[split.length - 1].length());

		scanner.close();
	}

}
