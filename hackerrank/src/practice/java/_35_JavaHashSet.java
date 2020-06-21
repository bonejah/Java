package practice.java;

import java.util.HashSet;
import java.util.Scanner;

public class _35_JavaHashSet {
	
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		int t = scanner.nextInt();
		
		HashSet<String> myHash = new HashSet<String>();
		
		String[] pair_left = new String[t];
		String[] pair_right = new String[t];
		
		for (int i = 0; i < t; i++) {
			pair_left[i] = scanner.next();
			pair_right[i] = scanner.next();
		}
		
		for (int i = 0; i < t; i++) {
			myHash.add(pair_left[i]+"#"+pair_right[i]);
			System.out.println(myHash.size());
		}
		
		scanner.close();
	}

}
