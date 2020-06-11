package teste.muitospramuitos;

import infra.DAO;
import muitospramuitos.Ator;
import muitospramuitos.Filme;

public class NovoFilmeAtor {
	
	public static void main(String[] args) {
		Filme filmeA = new Filme("Star Wars", 8.9);
		Filme filmeB = new Filme("O Fugitivo", 8.1);
		
		Ator atorA = new Ator("Harrison Ford");
		Ator atorB = new Ator("Carrie Fisher");
		
		filmeA.adicionaAtor(atorA);
		filmeA.adicionaAtor(atorB);
		
		filmeB.adicionaAtor(atorA);
		
		DAO<Filme> dao = new DAO<Filme>();
		dao.incluirAtomico(filmeA);
	}

}
