package br.com.deitel.cap.twenty.eight;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class DisplayAuthors {
	// URL do banco de dados
	static final String DATABASE_URL = "jdbc:mysql://localhost/books";

	public static void main(String[] args) {
		Connection connection = null; // gerencia a conexaop
		Statement statement = null; // instrucao de consulta
		ResultSet resultSet = null; // gerencia resultados

		// conecta-se ao banco de dados books e o consulta
		try {
			// estabelece a conexao com o banco de dados
			connection = DriverManager.getConnection(DATABASE_URL, "deitel", "deitel");

			// cria Statement para consultar banco de dados
			statement = connection.createStatement();

			// consulta o banco de dados
			resultSet = statement.executeQuery("SELECT AuthorID, FirstName, LastName FROM Authors");

			// processa os resultados da consulta
			ResultSetMetaData metaData = resultSet.getMetaData();
			int numberOfColumns = metaData.getColumnCount();
			System.out.println("Authors Table of Books Database:\n");

			for (int i = 1; i <= numberOfColumns; i++) {
				System.out.printf("%-8s\t", metaData.getColumnName(i));
			}

			System.out.println();

			while (resultSet.next()) {
				for (int i = 1; i <= numberOfColumns; i++) {
					System.out.printf("%-8s\t", resultSet.getObject(i));
				}

				System.out.println();
			}
		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
		} finally {
			// assegura que o resultSet, a instrucao e a conexao estejam
			// fechados
			try {
				resultSet.close();
				statement.close();
				connection.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
