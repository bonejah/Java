package br.com.devdojo.javacore.jdbc.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.devdojo.javacore.jdbc.classes.Carro;
import br.com.devdojo.javacore.jdbc.classes.Comprador;
import br.com.devdojo.javacore.jdbc.conn.ConexaoFactory;

public class CarroDAOImpl implements CarroDAO {

	@Override
	public void save(Carro carro) {
		String sql = "insert into devdojo.carro (placa, nome, compradorid) values (?, ?, ?)";

		try (Connection conn = ConexaoFactory.getConexao(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, carro.getPlaca());
			pstmt.setString(2, carro.getNome());
			pstmt.setInt(3, carro.getComprador().getId());
			pstmt.executeUpdate();
			System.out.println("Registro inserido com sucesso");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void update(Carro carro) {
		if (carro == null || carro.getId() == null) {
			System.out.println("Não foi possivel atualizar o registro");
			return;
		}

		String sql = "update devdojo.carro set placa = ?, nome = ? where id = ?";

		try (Connection conn = ConexaoFactory.getConexao(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, carro.getPlaca());
			pstmt.setString(2, carro.getNome());
			pstmt.setInt(3, carro.getId());
			pstmt.executeUpdate();
			System.out.println("Registro atualizado com sucesso");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete(Carro carro) {
		if (carro == null || carro.getId() == null) {
			System.out.println("Não foi possivel excluir o registro");
			return;
		}

		String sql = "delete from devdojo.carro where id = ?";

		try (Connection conn = ConexaoFactory.getConexao(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setInt(1, carro.getId());
			pstmt.executeUpdate();
			System.out.println("Registro excluido com sucesso");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Carro> selectAll() {
		String sql = "select id, placa, nome, compradorid from devdojo.carro";
		List<Carro> lsCarro = new ArrayList<>();

		try (Connection conn = ConexaoFactory.getConexao();
				PreparedStatement pstmt = conn.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery()) {

			while (rs.next()) {
				Comprador comprador = CompradorDAO.searchById(rs.getInt("compradorid"));
				lsCarro.add(new Carro(rs.getInt("id"), rs.getString("nome"), rs.getString("placa"), comprador));
			}
			System.out.println("Registro(s) recuperado(s) com sucesso");
			return lsCarro;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public List<Carro> searchByName(String nome) {
		String sql = "select id, placa, nome, compradorid from devdojo.carro where nome like ?";
		List<Carro> lsCarro = new ArrayList<>();

		try (Connection conn = ConexaoFactory.getConexao(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, "%" + nome + "%");
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				Comprador comprador = CompradorDAO.searchById(rs.getInt("comprador"));
				lsCarro.add(new Carro(rs.getInt("id"), rs.getString("nome"), rs.getString("placa"), comprador));
			}

			ConexaoFactory.close(conn, pstmt, rs);
			System.out.println("Registro(s) recuperado(s) com sucesso");
			return lsCarro;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

}
