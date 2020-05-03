package com.loiane.data.structure.stack.test;

import com.loiane.data.structure.stack.Stack;

public class Class15 {

	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<Integer>();
		System.out.println(stack.size());
		System.out.println("Stack is empty?: " + stack.isEmpty());

		for (int i = 1; i <= 1; i++) {
			stack.push(i);
		}

		System.out.println(stack);
		System.out.println(stack.size());
		System.out.println("Stack is empty?: " + stack.isEmpty());
	}
}
