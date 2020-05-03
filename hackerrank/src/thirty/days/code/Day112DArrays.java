package thirty.days.code;

import java.util.Scanner;

public class Day112DArrays {

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		int[][] arr = new int[6][6];

		for (int i = 0; i < 6; i++) {
			String[] arrRowItems = scanner.nextLine().split(" ");
			scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
			for (int j = 0; j < 6; j++) {
				int arrItem = Integer.parseInt(arrRowItems[j]);
				arr[i][j] = arrItem;
			}
		}

		int tmp_hourglass;
		int max_hourglass = 0;

		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				tmp_hourglass = 0;
				
				// sum top
				tmp_hourglass += arr[i][j];
				tmp_hourglass += arr[i][j + 1];
				tmp_hourglass += arr[i][j + 2];

				// sum middle
				tmp_hourglass += arr[i + 1][j + 1];

				// sum bottom
				tmp_hourglass += arr[i + 2][j];
				tmp_hourglass += arr[i + 2][j + 1];
				tmp_hourglass += arr[i + 2][j + 2];
				
				if (tmp_hourglass > max_hourglass || i == 0 && j == 0) {
					max_hourglass = tmp_hourglass;
				}
			}
		}
		
		System.out.println(max_hourglass);
		scanner.close();

	}

}
