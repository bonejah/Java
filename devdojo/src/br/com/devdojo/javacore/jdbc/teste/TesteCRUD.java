package br.com.devdojo.javacore.jdbc.teste;

import java.util.List;
import java.util.Scanner;

import br.com.devdojo.javacore.jdbc.classes.Comprador;
import br.com.devdojo.javacore.jdbc.db.CompradorDAO;



public class TesteCRUD {
	private static Scanner teclado = new Scanner(System.in);

	public static void main(String[] args) {
		int op;
		while (true) {
			menu();
			op = Integer.parseInt(teclado.nextLine());

			if (op == 0) {
				System.out.println("Saindo do sistema...");
				break;
			}
			
			if (op == 1) {
				menuComprador();
				op = Integer.parseInt(teclado.nextLine());
				CompradorCRUD.executar(op);
				break;
			}
			
			if (op == 2) {
				menuCarro();
				op = Integer.parseInt(teclado.nextLine());
				CarroCRUD.executar(op);
				break;
			}
			
		}

	}
	
	private static void menu() {
		System.out.println("Selecione uma opção");
		System.out.println("1 - Comprador");
		System.out.println("2 - Carro");
		System.out.println("0 - Sair");
		
	}
	
	private static void menuComprador() {
		System.out.println("\nDigite a opção para começar");
		System.out.println("1 - Inserir Comprador");
		System.out.println("2 - Atualizar Comprador");
		System.out.println("3 - Listar todos os compradores");
		System.out.println("4 - Busca comprador por nome");
		System.out.println("5 - Deletar comprador");
		System.out.println("9 - Voltar");
	}
	
	private static void menuCarro() {
		System.out.println("\nDigite a opção para começar");
		System.out.println("1 - Inserir Carro");
		System.out.println("2 - Atualizar Carro");
		System.out.println("3 - Listar todos os carros");
		System.out.println("4 - Busca carro por nome");
		System.out.println("5 - Deletar carro");
		System.out.println("9 - Voltar");
	}
}
