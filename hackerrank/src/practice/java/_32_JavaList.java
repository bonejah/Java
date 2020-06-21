package practice.java;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class _32_JavaList {

	public static void main(String[] args) {
		
		List<Integer> listNumbers = new ArrayList<Integer>();
		Scanner scanner = new Scanner(System.in);

		System.out.println("Please enter size array:");
		int size = scanner.nextInt();
		
		System.out.println("Enter the numbers");
		for (int i = 0; i < size; i++) {
			listNumbers.add(scanner.nextInt());
		}
		
		System.out.println("Enter number(s) querie(s)");
		int queries = scanner.nextInt();
		
		System.out.println("Enter type operation (Insert/Delete)");
		for (int i = 0; i < queries; i++) {
			String action = scanner.nextLine();
			
			if (action.toLowerCase().equals("insert")) {
				int index = scanner.nextInt();
				int element = scanner.nextInt();
				listNumbers.add(index, element);
			} else if (action.toLowerCase().equals("delete")) {
				int index = scanner.nextInt();
				listNumbers.remove(index);
			}
		}
		
		listNumbers.forEach(num -> System.out.println(num));
		
		scanner.close();
		
	}
	
}
