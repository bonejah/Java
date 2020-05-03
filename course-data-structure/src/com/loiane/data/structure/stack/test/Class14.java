package com.loiane.data.structure.stack.test;

import com.loiane.data.structure.stack.Stack;

public class Class14 {

	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<Integer>();
		
		for (int i = 1; i <= 10; i++) {
			stack.push(i);
		}
		
		System.out.println(stack);
		System.out.println(stack.size());
	}
}
