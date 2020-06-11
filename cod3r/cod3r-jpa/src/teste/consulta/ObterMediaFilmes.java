package teste.consulta;

import infra.DAO;
import modelo.consulta.NotaFilme;

public class ObterMediaFilmes {

	public static void main(String[] args) {
		DAO<NotaFilme> dao = new DAO<NotaFilme>();
		NotaFilme resultado = dao.consultarUm("obterMediaGeralDosFilmes");
		
		if (resultado != null) {
			System.out.println("Media dos filmes: " + resultado.getMedia());
		}
		
		dao.fechar();
	}

}
