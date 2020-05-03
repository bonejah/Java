package br.com.deitel.cap.twenty.two;

import java.util.Random;

public class TreeTest {
	public static void main(String[] args) {
		Tree<Integer> tree = new Tree<Integer>();
		int value;
		Random randomNumber = new Random();
		
		System.out.println("Inserting the following values: ");
		
		// insere 10 inteiros aleatorios de 0-99 na arvore
		for (int i = 1; i <= 10; i++) {
			value = randomNumber.nextInt(100);
			System.out.printf("%d ", value);
			tree.insertNode(value);
		}
		
		System.out.println("\n\nPreorder traversal");
		tree.preorderTraversal(); // realiza percurso na pre-ordem da arvore
		
		System.out.println("\n\nInorder traversal");
		tree.inorderTraversal(); // realiza percurso na ordem da arvore

		System.out.println("\n\nPostorder traversal");
		tree.postorderTraversal(); // realiza percurso na pos-ordem da arvore

	}
}
