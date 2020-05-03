package com.loiane.data.structure.stack.labs;

import java.util.Stack;

public class Exe6 {
	
	final static String OPEN = "({[";
	final static String CLOSE = ")}]";
	
	public static void main(String[] args) {
		printResult("A + B");
		printResult("A + B + (C - D)");
		printResult("{[()]}[]{()}");
		printResult("{[(]}[]()}");
		printResult("A + B + C - D)");
	}
	
	public static void printResult(String word) {
		System.out.println("The word " + word + ", is balanced?: " + isSymbolsBalanced(word));
	}
	
	public static boolean isSymbolsBalanced(String expression) {
		Stack<Character> stack = new Stack<Character>();
		int index = 0;
		char symbol, top;
		
		while (index < expression.length()) {
			symbol = expression.charAt(index);
			
			if (OPEN.indexOf(symbol) > -1) {
				stack.push(symbol);
			} else if (CLOSE.indexOf(symbol) > -1) {
				if (stack.isEmpty()) {
					return false;
				} else {
					top = stack.pop();
					
					if(OPEN.indexOf(top) != CLOSE.indexOf(symbol)) {
						return false;
					}
				}
			}
			
			index++;
		}
		
		return true;
	}
	
}
