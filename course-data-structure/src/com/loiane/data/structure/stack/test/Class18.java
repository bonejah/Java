package com.loiane.data.structure.stack.test;

import com.loiane.data.structure.stack.Stack;

public class Class18 {

	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<Integer>();
		java.util.Stack<Integer> stackJava = new java.util.Stack<Integer>();
		
		System.out.println(stackJava.isEmpty());
		
		stackJava.push(1);
		stackJava.push(2);
		stackJava.push(3);

		System.out.println(stackJava.isEmpty());
		System.out.println(stackJava.size());
		System.out.println(stackJava.peek());
		System.out.println(stackJava.pop());
		System.out.println(stackJava.peek());
	}
}
