package com.loiane.data.structure.stack.test;

import com.loiane.data.structure.stack.Stack;

public class Class17 {

	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<Integer>();
		
		for (int i = 1; i <= 100; i++) {
			stack.push(i);
		}
		
		System.out.println(stack);
		System.out.println("Pop element: " + stack.pop());
		System.out.println("Pop element: " + stack.pop());
	}
}
