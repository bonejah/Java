package br.com.devdojo.javacore.polimorfismo;

public class ArquivoDAOImpl implements GenericDAO {

	@Override
	public void save() {
		System.out.println("Salvando dados no arquivo...");
	}

}
