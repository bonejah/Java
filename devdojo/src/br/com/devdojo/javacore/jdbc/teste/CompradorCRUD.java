package br.com.devdojo.javacore.jdbc.teste;

import java.util.List;
import java.util.Scanner;

import br.com.devdojo.javacore.jdbc.classes.Comprador;
import br.com.devdojo.javacore.jdbc.db.CompradorDAO;

public class CompradorCRUD {
	private static Scanner teclado = new Scanner(System.in);
	
	public static void executar(int op) {
		switch (op) {
		case 1:
			inserir();
			break;
		case 2:
			atualizar();
			break;	
		case 3:
			listar();
			break;	
		case 4:
			System.out.println("Digite o nome");
			buscarPorNome(teclado.nextLine());
			break;
		case 5:
			deletar();
			break;
		default:
			break;
		}
	}

	private static void inserir() {
		Comprador comprador = new Comprador();
		System.out.println("Nome: ");
		comprador.setNome(teclado.nextLine());
		System.out.println("Cpf: ");
		comprador.setCpf(teclado.nextLine());
		CompradorDAO.save(comprador);
	}
	
	public static List<Comprador> listar() {
		List<Comprador> compradorList = CompradorDAO.selectAll();
		
		for (int i = 0; i < compradorList.size(); i++) {
			Comprador comprador = compradorList.get(i);
			System.out.println("[" + i + "] " + comprador.getNome() + " " + comprador.getCpf());
		}
		
		return compradorList;
	}
	
	private static void atualizar() {
		System.out.println("Selecione um dos compradores abaixo");
		List<Comprador> compradorList = listar();
		Comprador comprador = compradorList.get(Integer.parseInt(teclado.nextLine()));
		System.out.println("Novo nome ou enter para manter o mesmo");
		String nome = teclado.nextLine();
		System.out.println("Novo cpf ou enter para manter o mesmo");
		String cpf = teclado.nextLine();
		
		if (!nome.isEmpty()) {
			comprador.setNome(nome);
		}
		
		if (!cpf.isEmpty()) {
			comprador.setCpf(cpf);
		}
		
		CompradorDAO.update(comprador);
	}
	
	private static List<Comprador> buscarPorNome(String nome) {
		List<Comprador> compradorList = CompradorDAO.searchByName(nome);
		
		for (int i = 0; i < compradorList.size(); i++) {
			Comprador comprador = compradorList.get(i);
			System.out.println("[" + i + "] " + comprador.getNome() + " " + comprador.getCpf());
		}
		
		return compradorList;
	}
	
	private static void deletar() {
		System.out.println("Selecione um dos compradores abaixo para deletar");
		List<Comprador> compradorList = listar();
		int index = Integer.parseInt(teclado.nextLine());
		
		System.out.println("Tem certeza? S/N");
		String op = teclado.nextLine();
		if (op.startsWith("s")) {
			CompradorDAO.delete(compradorList.get(index));
			System.out.println("Comprador deletado com sucesso!");
		}
	}
}
