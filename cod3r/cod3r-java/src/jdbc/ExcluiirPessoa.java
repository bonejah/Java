package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class ExcluiirPessoa {

	public static void main(String[] args) throws SQLException {

		Scanner scanner = new Scanner(System.in);

		System.out.println("Informe o codigo a ser excluido: ");
		int codigoASerExcluido = scanner.nextInt();

		String delete = "DELETE FROM pessoas WHERE codigo = ?";
		
		Connection connection = FabricaConexao.getConnection();

		PreparedStatement pstmt = connection.prepareStatement(delete);
		pstmt.setInt(1, codigoASerExcluido);
		pstmt.execute();

		System.out.println("Registro: " + codigoASerExcluido + " excluido com sucesso");
		
		pstmt.close();
		connection.close();
		scanner.close();

	}

}
