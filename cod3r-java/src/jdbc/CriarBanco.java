package jdbc;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class CriarBanco {

	public static void main(String[] args) throws SQLException {
		
//		String url = "jdbc:mysql://localhost:3306";
//		String user = "root";
//		String password = "rootadmin";
//		
//		Connection connection = DriverManager.getConnection(url, user, password);
		
		Connection connection = FabricaConexao.getConnection();
		
		Statement statement = connection.createStatement();
		statement.execute("CREATE DATABASE IF NOT EXISTS cod3r_java");
		
		System.out.println("Banco criado com sucesso");
		connection.close();
	}
	
	
}
