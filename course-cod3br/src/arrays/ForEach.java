package arrays;

import java.util.Arrays;

public class ForEach {

	public static void main(String[] args) {
		double[] notas = {9.9, 8.7, 7.2, 9.4};
		System.out.println(Arrays.toString(notas));
		
		for (double d : notas) {
			System.out.println(d);
		}
	}
	
}
