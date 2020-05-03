package br.com.devdojo.javacore.polimorfismo.teste;

import br.com.devdojo.javacore.polimorfismo.ArquivoDAOImpl;
import br.com.devdojo.javacore.polimorfismo.DataBaseDAOImpl;
import br.com.devdojo.javacore.polimorfismo.GenericDAO;

public class DAOTeste {

	public static void main(String[] args) {
//		GenericDAO genericDAO = new DataBaseDAOImpl();
		GenericDAO genericDAO = new ArquivoDAOImpl();
		genericDAO.save();
	}
}
