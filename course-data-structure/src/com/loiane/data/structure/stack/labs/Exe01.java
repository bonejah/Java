package com.loiane.data.structure.stack.labs;

import java.util.Scanner;

import com.loiane.data.structure.stack.Stack;

public class Exe01 {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<Integer>();

		Scanner scan = new Scanner(System.in);

		for (int i = 0; i < 5; i++) {
			System.out.println("Enter with a number");

			int inputNum = Integer.parseInt(scan.nextLine());

			if (inputNum % 2 == 0) {
				System.out.println("Push number: " + inputNum);
				stack.push(inputNum);
			} else {
				Integer popNum = stack.pop();

				if (popNum == null) {
					System.out.println("Stack is empty!!");
				} else {
					System.out.println("Odd number: " + popNum);
				}
			}
		}

		System.out.println("All numbers was read, pop numbers of stack... ");

		while (!stack.isEmpty()) {
			Integer popNum = stack.pop();
			System.out.println("Pop element: " + popNum);
		}

		System.out.println("All numbers was poped... ");
	}

}
