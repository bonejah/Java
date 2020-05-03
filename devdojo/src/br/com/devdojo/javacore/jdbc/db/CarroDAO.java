package br.com.devdojo.javacore.jdbc.db;

import java.util.List;

import br.com.devdojo.javacore.jdbc.classes.Carro;

public interface CarroDAO {

	void save(Carro carro);

	void update(Carro carro);

	void delete(Carro carro);

	List<Carro> selectAll();

	List<Carro> searchByName(String nome);

}
