package challenges;

import java.util.Scanner;

public class Java2DArray {

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		int[][] arr = new int[6][6];

		for (int row = 0; row < 6; row++) {
			String[] arrRowItems = scanner.nextLine().split(" ");
			scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

			for (int col = 0; col < 6; col++) {
				int arrItem = Integer.parseInt(arrRowItems[col]);
				arr[row][col] = arrItem;
			}
		}
	
		System.out.println(maxHourGlass(arr));
		
		scanner.close();
	}
	
	public static int maxHourGlass(int arr[][]) {
		int max = Integer.MIN_VALUE;
		
		for (int row = 0; row < 4; row++) {
			for (int col = 0; col < 4; col++) {
				int sum = findSum(arr, row, col);
				max = Math.max(max, sum);
			}
		}
		
		return max;
	}
	
	public static int findSum(int arr[][], int row, int col) {
		int sum = arr[row + 0][col + 0] + arr[row + 0][col + 1] + arr[row + 0][col + 2]
										+ arr[row + 1][col + 1] +	
				  arr[row + 2][col + 0] + arr[row + 2][col + 1] + arr[row + 2][col + 2];		
		return sum;
	}
	
}
