package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ConsultarPessoas2 {

	public static void main(String[] args) throws SQLException {

		Scanner scanner = new Scanner(System.in);

		System.out.println("Informe um nome a ser pesquisado: ");
		String nomeASerPesquisado = scanner.nextLine();

		String sql = "SELECT * FROM pessoas WHERE nome LIKE ?";

		Connection connection = FabricaConexao.getConnection();

		PreparedStatement pstmt = connection.prepareStatement(sql);
		pstmt.setString(1, "%" + nomeASerPesquisado + "%");

		ResultSet result = pstmt.executeQuery();

		List<Pessoa> lsPessoas = new ArrayList<Pessoa>();

		while (result.next()) {
			int codigo = result.getInt("codigo");
			String nome = result.getString("nome");
			lsPessoas.add(new Pessoa(codigo, nome));
		}

		if (lsPessoas.size() > 0) {
			lsPessoas.forEach(System.out::println);
		} else {
			System.out.println("Nome: " + nomeASerPesquisado + ", não foi encontrado!!!");
		}
		
		pstmt.close();
		connection.close();
		scanner.close();

	}

}
