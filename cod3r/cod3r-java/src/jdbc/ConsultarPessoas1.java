package jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ConsultarPessoas1 {

	public static void main(String[] args) throws SQLException {

		Connection connection = FabricaConexao.getConnection();

		String sql = "SELECT * FROM pessoas";

		Statement stmt = connection.createStatement();

		ResultSet result = stmt.executeQuery(sql);

		List<Pessoa> lsPessoas = new ArrayList<Pessoa>();

		while (result.next()) {
			int codigo = result.getInt("codigo");
			String nome = result.getString("nome");
			lsPessoas.add(new Pessoa(codigo, nome));
		}
		
		lsPessoas.forEach(System.out::println);

		stmt.close();
		connection.close();

	}

}
