package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class AtualizarPessoa {

	public static void main(String[] args) throws SQLException {

		Scanner scanner = new Scanner(System.in);

		System.out.println("Informe o codigo a ser pesquisado: ");
		int codigoAserPesquisado = scanner.nextInt();

		String select = "SELECT * FROM pessoas WHERE codigo = ?";
		String update = "UPDATE pessoas SET nome = ? WHERE codigo = ?";

		Connection connection = FabricaConexao.getConnection();

		PreparedStatement pstmt = connection.prepareStatement(select);
		pstmt.setInt(1, codigoAserPesquisado);

		ResultSet result = pstmt.executeQuery();

		if (result.next()) {
			int codigo = result.getInt(1);
			String nome = result.getString(2);
			Pessoa pessoa = new Pessoa(codigo, nome);

			scanner.nextLine();
			
			System.out.println("Informe o novo nome: ");
			String nomeAserAtualizado = scanner.nextLine();
			
			pstmt.close();
			pstmt = connection.prepareStatement(update);
			pstmt.setString(1, nomeAserAtualizado);
			pstmt.setInt(2, pessoa.getCodigo());
			pstmt.execute();
			
			System.out.println("Nome alterado com sucesso :)");
		} else {
			System.out.println("Pessoa nao encontrada :(");
		}
		
		pstmt.close();
		connection.close();
		scanner.close();

	}
	
}
