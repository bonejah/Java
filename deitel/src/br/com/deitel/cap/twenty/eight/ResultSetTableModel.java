package br.com.deitel.cap.twenty.eight;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.table.AbstractTableModel;

public class ResultSetTableModel extends AbstractTableModel {
	private Connection connection; // gerencia a conexaop
	private Statement statement; // instrucao de consulta
	private ResultSet resultSet; // gerencia resultados
	private ResultSetMetaData metaData;
	private int numberOfRows;

	// monitora o status de conexao de banco de dados
	private boolean connectedToDatabase = false;

	public ResultSetTableModel(String url, String userName, String password, String query) throws SQLException {
		// conecta-se ao banco de dados
		connection = DriverManager.getConnection(url, userName, password);
		statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

		// atualiza o status de conexao do banco de dados
		connectedToDatabase = true;

		// configura consulta e a executa
		setQuery(query);
	}

	public void setQuery(String query) throws SQLException, IllegalStateException {
		// assegura que a conexao do bd esta disponivel
		if (!connectedToDatabase)
			throw new IllegalStateException("Not Connected to Database");

		// especifica a consulta e a executa
		resultSet = statement.executeQuery(query);

		// obtem os metadados para o ResultSet
		metaData = resultSet.getMetaData();

		// determina o numero de linhas em ResultSet
		resultSet.last(); // move para a ultima linha
		numberOfRows = resultSet.getRow(); // obtem o numero da linha

		// notifica a JTable de que o modelo foi alterado
		fireTableStructureChanged();
	}

	@Override
	public Class getColumnClass(int columnIndex) throws IllegalStateException {
		// assegura que a conexao do bd esta disponivel
		if (!connectedToDatabase)
			throw new IllegalStateException("Not Connected to Database");

		// determina a classe Java de coluna
		try {
			String className = metaData.getColumnClassName(columnIndex + 1);
			return Class.forName(className);
		} catch (Exception exception) {
			exception.printStackTrace();
		}

		return Object.class;
	}

	@Override
	public int getRowCount() {
		if (!connectedToDatabase)
			throw new IllegalStateException("Not Connected to Database");
		return numberOfRows;
	}

	@Override
	public int getColumnCount() throws IllegalStateException {
		// assegura que a conexao do bd esta disponivel
		if (!connectedToDatabase)
			throw new IllegalStateException("Not Connected to Database");

		// determina o numero de colunas
		try {
			return metaData.getColumnCount();
		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
		}

		return 0;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		if (!connectedToDatabase)
			throw new IllegalStateException("Not Connected to Database");

		// determina o numero de colunas
		try {
			resultSet.absolute(rowIndex + 1);
			return resultSet.getObject(columnIndex + 1);
		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
		}
		return "";
	}

	@Override
	public String getColumnName(int column) throws IllegalStateException {
		if (!connectedToDatabase)
			throw new IllegalStateException("Not Connected to Database");

		// determina o numero de colunas
		try {
			return metaData.getColumnName(column + 1);
		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
		}

		return "";
	}

	public void disconnectFromDatabase() {
		if (connectedToDatabase) {
			// fecha Statement e Connection
			try {
				resultSet.close();
				statement.close();
				connection.close();
			} catch (SQLException sqlException) {
				sqlException.printStackTrace();
			} finally {
				connectedToDatabase = false;
			}
		}
	}
}
