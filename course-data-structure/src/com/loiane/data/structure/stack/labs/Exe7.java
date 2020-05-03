package com.loiane.data.structure.stack.labs;

import java.util.Stack;

public class Exe7 {

	public static void main(String[] args) {
		Stack<Integer> stackOriginal = new Stack<>();
		Stack<Integer> stackDestiny = new Stack<>();
		Stack<Integer> stackAux = new Stack<>();

		stackOriginal.push(3);
		stackOriginal.push(2);
		stackOriginal.push(1);
		
		towerOfHanoi(stackOriginal.size(), stackOriginal, stackDestiny, stackAux);
	}

	public static void towerOfHanoi(int n, Stack<Integer> original, 
			Stack<Integer> destiny, Stack<Integer> aux) {

		if (n > 0) {
			towerOfHanoi(n -1, original, aux, destiny);
			destiny.push(original.pop());
			System.out.println("--------------------");
			System.out.println("Original: " + original);
			System.out.println("Destiny: " + destiny);
			System.out.println("Aux: " + aux);
			towerOfHanoi(n -1, aux, destiny, original);
		}
	}

}
