package com.loiane.data.structure.stack.labs;

import java.util.Scanner;

import com.loiane.data.structure.stack.Stack;

public class Exe2 {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		Stack<Integer> stackEven = new Stack<Integer>();
		Stack<Integer> stackOdd = new Stack<Integer>();

		Scanner scan = new Scanner(System.in);

		for (int i = 0; i < 10; i++) {
			System.out.println("Enter with a number");

			int inputNum = Integer.parseInt(scan.nextLine());

			if (inputNum == 0) {
				Integer numPop = stackEven.pop();
				
				if (numPop == null) {
					System.err.println("Stack even is empty!");
				} else {
					System.out.println("Poping stack even...: " + numPop);
				}
				
				numPop = stackOdd.pop();
				
				if (numPop == null) {
					System.err.println("Stack odd is empty!");
				} else {
					System.out.println("Poping stack odd...: " + numPop);
				}
				
			} else if (inputNum % 2 == 0) {
				stackEven.push(inputNum);
			} else {
				stackOdd.push(inputNum);
			}
		}

		System.out.println(stackEven);
		System.out.println(stackOdd);
		
		System.out.println("Poping all stacks....");
		
		while(!stackEven.isEmpty()) {
			stackEven.pop();
		}
		
		while(!stackOdd.isEmpty()) {
			stackOdd.pop();
		}
		
		System.out.println(stackEven);
		System.out.println(stackOdd);
	}

}
