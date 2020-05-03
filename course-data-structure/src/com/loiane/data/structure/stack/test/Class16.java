package com.loiane.data.structure.stack.test;

import com.loiane.data.structure.stack.Stack;

public class Class16 {

	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<Integer>();
		System.out.println(stack.top());
		System.out.println(stack);
		
		for (int i = 1; i <= 2; i++) {
			stack.push(i);
		}

		System.out.println(stack.top());
		System.out.println(stack);
	}
}
