package com.loiane.data.structure.stack.labs;

import com.loiane.data.structure.stack.Stack;

public class Exe3 {
	
	public static void main(String[] args) {
		Stack<Book> stack = new Stack<Book>(20);
		
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
		System.out.println(stack.top());
		
		while(!stack.isEmpty()) {
			stack.pop();
		}
		
		System.out.println("Stack is empty? " + (stack.isEmpty() ? "YES" : "NO"));
	}

}
