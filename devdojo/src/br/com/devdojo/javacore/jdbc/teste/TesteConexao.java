package br.com.devdojo.javacore.jdbc.teste;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import br.com.devdojo.javacore.jdbc.classes.Comprador;
import br.com.devdojo.javacore.jdbc.conn.ConexaoFactory;
import br.com.devdojo.javacore.jdbc.db.CompradorDB_OLD;


public class TesteConexao {
	public static void main(String[] args) {
//		testeConexao();
//		inserir();
//		excluir();
//		atualizar();
//		selectTudo();
//		selecionaPorNome();
//		CompradorDB.selectMetaData();
//		CompradorDB.checkDriverStatus();
//		CompradorDB.testeTypeScrolll();'
//		CompradorDB.updateLowerCase();
//		CompradorDB.searchByNameWithSQLInjection("icia' or 'x'='x");
//		CompradorDB.searchByNameWithPreparedStatement("icia");
		
//		Comprador comprador = new Comprador(1,"123.456.789.00", "BRUNO");
//		CompradorDB.updateWithPreparedStatement(comprador);

//		CompradorDB.searchByNameCallableStatement("oa");
		
//		CompradorDB.searchByNameRowSet("JOAO"); 
//		Comprador comprador = new Comprador(1,"123.456.789-00", "BRUNO");
//		CompradorDB.updateWithRowSet(comprador);
		
//		CompradorDB.updateWithRowSetCached(new Comprador(1,"123.456.789.00", "BRUNO"));
		try {
			CompradorDB_OLD.saveTransaction();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	
	public static void inserir() {
		Comprador comprador = new Comprador("456.789.098-11", "Leticia");
		CompradorDB_OLD.save(comprador);
	}
	
	public static void excluir() {
		Comprador comprador = new Comprador(3, "456.789.098-11", "Leticia");
		CompradorDB_OLD.delete(comprador);
	}
	
	public static void atualizar() {
		Comprador comprador = new Comprador(3,  "456.789.098-11", "Leticia Lima");
		CompradorDB_OLD.update(comprador);
	}
	
	public static void selectTudo() {
		List<Comprador> lsComprador = CompradorDB_OLD.selectAll();
		for (Comprador comprador : lsComprador) {
			System.out.println(comprador);
		}
	}
	
	public static void selecionaPorNome() {
		List<Comprador> lsComprador = CompradorDB_OLD.searchByName("Bruno");
		for (Comprador comprador : lsComprador) {
			System.out.println(comprador);
		}
	}
	
	public static void testeConexao() {
		Connection connection = ConexaoFactory.getConexao();
		try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
