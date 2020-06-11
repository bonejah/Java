package teste.consulta;

import java.util.List;

import infra.DAO;
import muitospramuitos.Ator;
import muitospramuitos.Filme;

public class ObterFilmes {

	public static void main(String[] args) {
		DAO<Filme> dao = new DAO<Filme>();

		List<Filme> filmes = dao.consultar("obterFilmesComNotaMaiorQUe", "nota", 8.5);
		
//		filmes.stream()
//			.forEach(filme -> System.out.println("Filme: " + filme.getNome()));
		
		for (Filme filme : filmes) {
			System.out.println("Filme: " + filme.getNome());
			
			for (Ator ator : filme.getAtores()) {
				System.out.println("Ator: " + ator.getNome());
			}
		}
		
	}
}
