package br.com.devdojo.javacore.jdbc.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.devdojo.javacore.jdbc.classes.Comprador;
import br.com.devdojo.javacore.jdbc.conn.ConexaoFactory;

public class CompradorDAO {

	public static void save(Comprador comprador) {
		String sql = "insert into devdojo.comprador (cpf, nome) values (?, ?)";

		try (Connection conn = ConexaoFactory.getConexao(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, comprador.getCpf());
			pstmt.setString(2, comprador.getNome());
			pstmt.executeUpdate();
			System.out.println("Registro inserido com sucesso");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void update(Comprador comprador) {
		if (comprador == null || comprador.getId() == null) {
			System.out.println("Não foi possivel atualizar o registro");
			return;
		}

		String sql = "update devdojo.comprador set cpf = ?, nome = ? where id = ?";

		try (Connection conn = ConexaoFactory.getConexao(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, comprador.getCpf());
			pstmt.setString(2, comprador.getNome());
			pstmt.setInt(3, comprador.getId());
			pstmt.executeUpdate();
			System.out.println("Registro atualizado com sucesso");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void delete(Comprador comprador) {
		if (comprador == null || comprador.getId() == null) {
			System.out.println("Não foi possivel excluir o registro");
			return;
		}

		String sql = "delete from devdojo.comprador where id = ?";

		try (Connection conn = ConexaoFactory.getConexao(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setInt(1, comprador.getId());
			pstmt.executeUpdate();
			System.out.println("Registro excluido com sucesso");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static List<Comprador> selectAll() {
		String sql = "select id, cpf, nome from devdojo.comprador";
		List<Comprador> lsComprador = new ArrayList<>();

		try (Connection conn = ConexaoFactory.getConexao();
				PreparedStatement pstmt = conn.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery()) {

			while (rs.next()) {
				lsComprador.add(new Comprador(rs.getInt(1), rs.getString("cpf"), rs.getString("nome")));
			}
			System.out.println("Registro(s) recuperado(s) com sucesso");
			return lsComprador;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	public static List<Comprador> searchByName(String nome) {
		String sql = "select id, cpf, nome from devdojo.comprador where nome like ?";
		List<Comprador> lsComprador = new ArrayList<>();

		try (Connection conn = ConexaoFactory.getConexao(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, "%" + nome + "%");
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				lsComprador.add(new Comprador(rs.getInt(1), rs.getString("cpf"), rs.getString("nome")));
			}

			ConexaoFactory.close(conn, pstmt, rs);
			System.out.println("Registro(s) recuperado(s) com sucesso");
			return lsComprador;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}
	
	public static Comprador searchById(Integer id) {
		String sql = "select id, cpf, nome from devdojo.comprador where id = ?";
		Comprador comprador = null;

		try (Connection conn = ConexaoFactory.getConexao(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				comprador = new Comprador(rs.getInt(1), rs.getString("cpf"), rs.getString("nome"));
			}

			ConexaoFactory.close(conn, pstmt, rs);
			System.out.println("Registro(s) recuperado(s) com sucesso");
			return comprador;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}


}
