package br.com.devdojo.javacore.jdbc.teste;

import java.util.List;
import java.util.Scanner;

import br.com.devdojo.javacore.jdbc.classes.Carro;
import br.com.devdojo.javacore.jdbc.classes.Comprador;
import br.com.devdojo.javacore.jdbc.db.CarroDAO;
import br.com.devdojo.javacore.jdbc.db.CarroDAOImpl;

public class CarroCRUD {
	private static Scanner teclado = new Scanner(System.in);
	private static CarroDAO dao = new CarroDAOImpl();

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
		Carro carro = new Carro();
		System.out.println("Nome: ");
		carro.setNome(teclado.nextLine());
		System.out.println("Placa: ");
		carro.setPlaca(teclado.nextLine());
		System.out.println("Selecione um dos compradores abaixo:");
		List<Comprador> lsCarros = CompradorCRUD.listar();
		carro.setComprador(lsCarros.get(Integer.parseInt(teclado.nextLine())));
		dao.save(carro);
	}

	private static List<Carro> listar() {
		List<Carro> carroList = dao.selectAll();

		for (int i = 0; i < carroList.size(); i++) {
			Carro carro = carroList.get(i);
			System.out.println(
					"[" + i + "] " + carro.getNome() + " " + carro.getPlaca() + " " + carro.getComprador().getNome());
		}

		return carroList;
	}

	private static void atualizar() {
		System.out.println("Selecione um dos carroes abaixo");
		List<Carro> carroList = listar();
		Carro carro = carroList.get(Integer.parseInt(teclado.nextLine()));
		System.out.println("Novo nome ou enter para manter o mesmo");
		String nome = teclado.nextLine();
		System.out.println("Nova placa ou enter para manter o mesmo");
		String placa = teclado.nextLine();

		if (!nome.isEmpty()) {
			carro.setNome(nome);
		}

		if (!placa.isEmpty()) {
			carro.setPlaca(placa);
		}

		dao.update(carro);
	}

	private static List<Carro> buscarPorNome(String nome) {
		List<Carro> carroList = dao.searchByName(nome);

		for (int i = 0; i < carroList.size(); i++) {
			Carro carro = carroList.get(i);
			System.out.println(
					"[" + i + "] " + carro.getNome() + " " + carro.getPlaca() + " " + carro.getComprador().getNome());
		}

		return carroList;
	}

	private static void deletar() {
		System.out.println("Selecione um dos carros abaixo para deletar");
		List<Carro> carroList = listar();
		int index = Integer.parseInt(teclado.nextLine());

		System.out.println("Tem certeza? S/N");
		String op = teclado.nextLine();
		if (op.startsWith("s")) {
			dao.delete(carroList.get(index));
			System.out.println("Carro deletado com sucesso!");
		}
	}
}
