package br.com.deitel.cap.ninetheen;

import java.util.Scanner;

public class LinearArrayTest {
	public static void main(String[] args) {
		// cria o objeto Scanner para inserir dados
		Scanner input = new Scanner(System.in);

		int searchInt; // chave de pesquisa
		int position; // localizacao da chave de pesquisa no array;

		// cria um array e gera saida
		LinearArray searchArray = new LinearArray(10);
		System.out.println(searchArray + "\n");

		// obtem a entrada do usuario
		System.out.print("Please enter an integer value (-1 to quit); ");
		searchInt = input.nextInt(); // lê o primeiro int do usuario

		while (searchInt != -1) {
			// realiza a pesquisa linear
			position = searchArray.linearSearch(searchInt);

			if (position == -1) {
				System.out.println("The integer " + searchInt + " was not found.\n");
			} else {
				System.out.println("The integer " + searchInt + " was found in position " + position + ".\n");
			}

			// obtem a entrada do usuario
			System.out.print("Please enter an integer value (-1 to quit); ");
			searchInt = input.nextInt(); // lê o primeiro int do usuario
		}
	}
}
