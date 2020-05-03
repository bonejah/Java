package com.loiane.data.structure.stack.labs;

import java.util.Stack;

public class Exe4 {

	public static void main(String[] args) {
		Stack<Book> stack = new Stack<Book>();

		Book book1 = new Book("BOOK1", "Bonejah", 2018, "JS on practice1");
		Book book2 = new Book("BOOK2", "Bonejah", 2018, "JS on practice2");
		Book book3 = new Book("BOOK3", "Bonejah", 2018, "JS on practice3");
		Book book4 = new Book("BOOK4", "Bonejah", 2018, "JS on practice4");
		Book book5 = new Book("BOOK5", "Bonejah", 2018, "JS on practice5");
		Book book6 = new Book("BOOK6", "Bonejah", 2018, "JS on practice6");

		System.out.println("Stack is empty? " + (stack.isEmpty() ? "YES" : "NO"));

		stack.push(book1);
		stack.push(book2);
		stack.push(book3);
		stack.push(book4);
		stack.push(book5);
		stack.push(book6);

		System.out.println("Stack is empty? " + (stack.isEmpty() ? "YES" : "NO"));
		System.out.println(stack);
		System.out.println(stack.peek());

		while (!stack.isEmpty()) {
			stack.pop();
		}

		System.out.println("Stack is empty? " + (stack.isEmpty() ? "YES" : "NO"));
	}

}
