package br.com.deitel.cap.twenty.eight;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PersonQueries {
	// URL de banco de dados, usuario e senha
	static final String DATABASE_URL = "jdbc:mysql://localhost/books";
	static final String USERNAME = "deitel";
	static final String PASSWORD = "deitel";

	private Connection connection = null; // gerencia a conexaop
	private PreparedStatement selectAllPeople = null;
	private PreparedStatement selectPeopleByLastName = null;
	private PreparedStatement insertNewPerson = null;

	public PersonQueries() {
		try {
			connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);

			// cria a consulta que seleciona todas as entradas da tabela
			selectAllPeople = connection.prepareStatement("SELECT * FROM Addresses");

			// cria a consulta que seleciona entradas com um sobrenome
			// especifico
			selectPeopleByLastName = connection.prepareStatement("SELECT * FROM Addresses WHERE LastName = ?");

			// cria insercao que adiciona uma nova entrada no BD
			insertNewPerson = connection.prepareStatement(
					"INSERT INTO Addresses " + "(FirstName, LastName, Email, PhoneNumber)" + "VALUES(?,?,?,?)");
		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
			System.exit(1);
		}
	}

	public List<Person> getAllPeople() {
		List<Person> results = null;
		ResultSet resultSet = null;

		try {
			// executeQuery retorna ResultSet que contem entradas
			// correspondentes
			resultSet = selectAllPeople.executeQuery();
			results = new ArrayList<Person>();

			while (resultSet.next()) {
				results.add(new Person(resultSet.getInt("addressID"), resultSet.getString("FirstName"),
						resultSet.getString("LastName"), resultSet.getString("Email"),
						resultSet.getString("PhoneNumber")));
			}
		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
		} finally {
			try {
				resultSet.close();
			} catch (SQLException sqlException2) {
				sqlException2.printStackTrace();
				close();
			}
		}

		return results;
	}

	public List<Person> getPeopleByLastName(String name) {
		List<Person> results = null;
		ResultSet resultSet = null;

		try {
			selectPeopleByLastName.setString(1, name);
			// executeQuery retorna ResultSet que contem entradas
			// correspondentes
			resultSet = selectPeopleByLastName.executeQuery();
			results = new ArrayList<Person>();

			while (resultSet.next()) {
				results.add(new Person(resultSet.getInt("addressID"), resultSet.getString("FirstName"),
						resultSet.getString("LastName"), resultSet.getString("Email"),
						resultSet.getString("PhoneNumber")));
			}
		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
		} finally {
			try {
				resultSet.close();
			} catch (SQLException sqlException2) {
				sqlException2.printStackTrace();
				close();
			}
		}

		return results;
	}

	public int addPerson(String fname, String lname, String email, String num) {
		int result = 0;

		try {
			insertNewPerson.setString(1, fname);
			insertNewPerson.setString(2, lname);
			insertNewPerson.setString(3, email);
			insertNewPerson.setString(4, num);

			// insere nova entrada e retorna o numero de linhas atualizadas
			result = insertNewPerson.executeUpdate();
		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
			close();
		}

		return result;
	}

	public void close() {
		try {
			connection.close();
		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
		}
	}
}
