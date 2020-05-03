package turing;

import java.util.Scanner;

class Solution {
	public static int numOffices(String[][] grid) {
		int result = 1;
		// Put your code here.
		
		

		return result;
	}
}

public class Rextester {
	
	public static String[][] getMatrix() {
		Scanner sc = new Scanner(System.in);
		int rowsLen = sc.nextInt();
		int colsLen = sc.nextInt();
		String matrix[][] = new String[rowsLen][colsLen];
		int i;
		for (i = 0; i < rowsLen; i++) {
			String line = sc.next();
			for (int j = 0; j < line.length(); j++) {
				matrix[i][j] = String.valueOf(line.charAt(j));
			}
		}
		return matrix;
	}

	public static void main(String args[]) {
		int result = Solution.numOffices(getMatrix());
		System.out.println(result);
	}
	
}