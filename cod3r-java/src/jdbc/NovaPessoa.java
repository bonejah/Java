package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class NovaPessoa {

	public static void main(String[] args) throws SQLException {
		Scanner scanner = new Scanner(System.in);

		System.out.println("Informe o nome: ");
		String nome = scanner.nextLine();
		
		String sql = " INSERT INTO pessoas (nome) values (?)";
		
		Connection connection = FabricaConexao.getConnection();
		
		PreparedStatement pstmt = connection.prepareStatement(sql);
		pstmt.setString(1, nome);
		pstmt.execute();
		
		System.out.println("Pessoa criada com sucesso");
		
		pstmt.close();
		connection.close();
		
		scanner.close();
	}
	
}
