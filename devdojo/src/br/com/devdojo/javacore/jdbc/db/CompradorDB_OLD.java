package br.com.devdojo.javacore.jdbc.db;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.JdbcRowSet;

import com.mysql.cj.jdbc.CallableStatement;

import br.com.devdojo.javacore.jdbc.classes.Comprador;
import br.com.devdojo.javacore.jdbc.classes.MyRowSetListener;
import br.com.devdojo.javacore.jdbc.conn.ConexaoFactory;

public class CompradorDB_OLD {

	public static void save(Comprador comprador) {
		String sql = "insert into devdojo.comprador (cpf, nome) values ('" + comprador.getCpf() + "', '"
				+ comprador.getNome() + "')";
		Connection connection = ConexaoFactory.getConexao();

		try {
			Statement stmt = connection.createStatement();
			stmt.executeUpdate(sql);
			ConexaoFactory.close(connection, stmt);
			System.out.println("Registro inserido com sucesso");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@SuppressWarnings("unused")
	public static void saveTransaction() throws SQLException {
		String sql1 = "insert into devdojo.comprador (cpf, nome) values ('Teste1', 'Teste Transaction')";
		String sql2 = "insert into devdojo.comprador (cpf, nome) values ('Teste2', 'Teste Transaction')";
		String sql3 = "insert into devdojo.comprador (cpf, nome) values ('Teste3', 'Teste Transaction')";
		Connection connection = ConexaoFactory.getConexao();

		try {
			connection.setAutoCommit(false);
			Statement stmt = connection.createStatement();
			stmt.executeUpdate(sql1);
			stmt.executeUpdate(sql2);
			
 
			
			stmt.executeUpdate(sql3);
			connection.commit();
			ConexaoFactory.close(connection, stmt);
			System.out.println("Registro inserido com sucesso");
		} catch (SQLException e) {
			e.printStackTrace();
			connection.rollback();
		}
	}
	

	public static void delete(Comprador comprador) {
		if (comprador == null || comprador.getId() == null) {
			System.out.println("Não foi possivel excluir o registro");
			return;
		}

		String sql = "delete from devdojo.comprador where id = " + comprador.getId();
		Connection connection = ConexaoFactory.getConexao();

		try {
			Statement stmt = connection.createStatement();
			stmt.executeUpdate(sql);
			ConexaoFactory.close(connection, stmt);
			System.out.println("Registro excluido com sucesso");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void update(Comprador comprador) {
		if (comprador == null || comprador.getId() == null) {
			System.out.println("Não foi possivel atualizar o registro");
			return;
		}

		String sql = "update devdojo.comprador set cpf = '" + comprador.getCpf() + "', nome = '" + comprador.getNome()
				+ "' where id = " + comprador.getId();
		Connection connection = ConexaoFactory.getConexao();

		try {
			Statement stmt = connection.createStatement();
			stmt.executeUpdate(sql);
			ConexaoFactory.close(connection, stmt);
			System.out.println("Registro atualizado com sucesso");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void updateWithPreparedStatement(Comprador comprador) {
		if (comprador == null || comprador.getId() == null) {
			System.out.println("Não foi possivel atualizar o registro");
			return;
		}

		String sql = "update devdojo.comprador set cpf = ?, nome = ? where id = ?";
		Connection connection = ConexaoFactory.getConexao();

		try {
			PreparedStatement pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, comprador.getCpf());
			pstmt.setString(2, comprador.getNome());
			pstmt.setInt(3, comprador.getId());
			
			pstmt.executeUpdate();
			
			ConexaoFactory.close(connection, pstmt);
			System.out.println("Registro atualizado com sucesso");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void updateWithRowSet(Comprador comprador) {
		if (comprador == null || comprador.getId() == null) {
			System.out.println("Não foi possivel atualizar o registro");
			return;
		}

//		String sql = "update devdojo.comprador set cpf = ?, nome = ? where id = ?";
		String sql = "select * from devdojo.comprador where id = ?";
		JdbcRowSet jrs = ConexaoFactory.getRowSetConnection();

		try {
			jrs.setCommand(sql);
//			jrs.setString(1, comprador.getCpf());
//			jrs.setString(2, comprador.getNome());
			jrs.setInt(1, comprador.getId());
			jrs.execute();
			jrs.next();
			jrs.updateString("cpf", "111.111.111-11");
			jrs.updateRow();
			ConexaoFactory.close(jrs);
			System.out.println("Registro atualizado com sucesso");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void updateWithRowSetCached(Comprador comprador) {
		if (comprador == null || comprador.getId() == null) {
			System.out.println("Não foi possivel atualizar o registro");
			return;
		}
		
		String sql = "SELECT * FROM comprador where id = ?";
		CachedRowSet cachedRowSet = ConexaoFactory.getRowSetConnectionCached();

		try {
			cachedRowSet.setCommand(sql);
			cachedRowSet.setInt(1, comprador.getId());
			cachedRowSet.execute();
			cachedRowSet.next();
			cachedRowSet.updateString("nome", "BPCL");
			cachedRowSet.updateRow();
//			Thread.sleep(8000);
			cachedRowSet.acceptChanges();
//			ConexaoFactory.close(cachedRowSet);
			System.out.println("Registro atualizado com sucesso");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}


	public static List<Comprador> selectAll() {
		String sql = "select id, cpf, nome from devdojo.comprador";
		Connection connection = ConexaoFactory.getConexao();
		List<Comprador> lsComprador = new ArrayList<>();

		try {
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {
				lsComprador.add(new Comprador(rs.getInt(1), rs.getString("cpf"), rs.getString("nome")));
			}

			ConexaoFactory.close(connection, stmt, rs);
			System.out.println("Registro(s) recuperado(s) com sucesso");
			return lsComprador;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	public static List<Comprador> searchByName(String nome) {
		String sql = "select id, cpf, nome from devdojo.comprador where nome like '%" + nome + "%'";
		Connection connection = ConexaoFactory.getConexao();
		List<Comprador> lsComprador = new ArrayList<>();

		try {
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {
				lsComprador.add(new Comprador(rs.getInt(1), rs.getString("cpf"), rs.getString("nome")));
			}

			ConexaoFactory.close(connection, stmt, rs);
			System.out.println("Registro(s) recuperado(s) com sucesso");
			return lsComprador;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	public static List<Comprador> searchByNameWithSQLInjection(String nome) {
		String sql = "select id, cpf, nome from devdojo.comprador where nome like '" + nome + "'";
		Connection connection = ConexaoFactory.getConexao();
		List<Comprador> lsComprador = new ArrayList<>();

		try {
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {
				lsComprador.add(new Comprador(rs.getInt(1), rs.getString("cpf"), rs.getString("nome")));
			}

			ConexaoFactory.close(connection, stmt, rs);
			System.out.println(lsComprador);
			System.out.println("Registro(s) recuperado(s) com sucesso");
			return lsComprador;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	public static List<Comprador> searchByNameWithPreparedStatement(String nome) {
		String sql = "select id, cpf, nome from devdojo.comprador where nome like ?";
		Connection connection = ConexaoFactory.getConexao();
		List<Comprador> lsComprador = new ArrayList<>();

		try {
			PreparedStatement pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, "%" + nome + "%");
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				lsComprador.add(new Comprador(rs.getInt(1), rs.getString("cpf"), rs.getString("nome")));
			}

			ConexaoFactory.close(connection, pstmt, rs);
			System.out.println(lsComprador);
			System.out.println("Registro(s) recuperado(s) com sucesso");
			return lsComprador;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}
	
	public static List<Comprador> searchByNameCallableStatement(String nome) {
		String sql = "Call devdojo.SP_GetCompradoresPorNome(?)";
		Connection connection = ConexaoFactory.getConexao();
		List<Comprador> lsComprador = new ArrayList<>();

		try {
			CallableStatement cs = (CallableStatement) connection.prepareCall(sql); 
			cs.setString(1, "%" + nome + "%");
			ResultSet rs = cs.executeQuery();

			while (rs.next()) {
				lsComprador.add(new Comprador(rs.getInt("id"), rs.getString("cpf"), rs.getString("nome")));
			}

			ConexaoFactory.close(connection, cs, rs);
			System.out.println(lsComprador);
			System.out.println("Registro(s) recuperado(s) com sucesso");
			return lsComprador;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	public static List<Comprador> searchByNameRowSet(String nome) {
		String sql = "Call devdojo.SP_GetCompradoresPorNome(?)";
		JdbcRowSet jrs = ConexaoFactory.getRowSetConnection();
		jrs.addRowSetListener(new MyRowSetListener());
		
		List<Comprador> lsComprador = new ArrayList<>();

		try {
			jrs.setCommand(sql);
			jrs.setString(1, nome);
			jrs.execute();

			while (jrs.next()) {
				lsComprador.add(new Comprador(jrs.getInt("id"), jrs.getString("cpf"), jrs.getString("nome")));
			}

			ConexaoFactory.close(jrs);
			System.out.println(lsComprador);
			System.out.println("Registro(s) recuperado(s) com sucesso");
			return lsComprador;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	

	public static void selectMetaData() {
		String sql = "select * from devdojo.comprador";
		Connection connection = ConexaoFactory.getConexao();
		List<Comprador> lsComprador = new ArrayList<>();

		try {
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			ResultSetMetaData rsmd = rs.getMetaData();
			rs.next();
			int qtdeColunas = rsmd.getColumnCount();

			System.out.println("Quantidade de colunas: " + qtdeColunas);
			for (int i = 1; i <= qtdeColunas; i++) {
				System.out.println("Tabela: " + rsmd.getTableName(i));
				System.out.println("Nome coluna: " + rsmd.getColumnName(i));
				System.out.println("Tamanho coluna: " + rsmd.getColumnDisplaySize(i));
			}

			ConexaoFactory.close(connection, stmt, rs);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void checkDriverStatus() {
		Connection connection = ConexaoFactory.getConexao();
		try {
			DatabaseMetaData dbmd = connection.getMetaData();
			if (dbmd.supportsResultSetType(ResultSet.TYPE_FORWARD_ONLY)) {
				System.out.println("Suporta TYPE_FORWARD_ONLY");

				if (dbmd.supportsResultSetConcurrency(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_UPDATABLE)) {
					System.out.println("Suporta CONCUR_UPDATABLE");
				}
			}

			if (dbmd.supportsResultSetType(ResultSet.TYPE_SCROLL_INSENSITIVE)) {
				System.out.println("Suporta TYPE_SCROLL_INSENSITIVE");

				if (dbmd.supportsResultSetConcurrency(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE)) {
					System.out.println("Suporta CONCUR_UPDATABLE");
				}
			}

			if (dbmd.supportsResultSetType(ResultSet.TYPE_SCROLL_SENSITIVE)) {
				System.out.println("Suporta TYPE_SCROLL_SENSITIVE");

				if (dbmd.supportsResultSetConcurrency(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE)) {
					System.out.println("Suporta CONCUR_UPDATABLE");
				}
			}

			ConexaoFactory.close(connection);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void testeTypeScrolll() {
		String sql = "select id, cpf, nome from devdojo.comprador";
		Connection connection = ConexaoFactory.getConexao();

		try {
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(sql);

			if (rs.last()) {
				System.out.println(
						"Ultima linha: " + new Comprador(rs.getInt(1), rs.getString("cpf"), rs.getString("nome")));
				System.out.println("Numero ultima linha: " + rs.getRow());
			}

			System.out.println("Retornou para a 1 linha: " + rs.first());
			System.out.println("Numero primeira linha: " + rs.getRow());

			rs.absolute(4);
			System.out.println("Linha: " + new Comprador(rs.getInt(1), rs.getString("cpf"), rs.getString("nome")));

			rs.relative(-2);
			System.out.println("Linha: " + new Comprador(rs.getInt(1), rs.getString("cpf"), rs.getString("nome")));

			System.out.println("É o ultimo? " + rs.isLast());
			System.out.println("É antes do ultimo? " + rs.isAfterLast());

			System.out.println("É o primeiro? " + rs.isFirst());
			System.out.println("É depois primeiro? " + rs.isBeforeFirst());

			System.out.println("----------------------------------------");
			rs.afterLast();
			while (rs.previous()) {
				System.out.println("Linha: " + new Comprador(rs.getInt(1), rs.getString("cpf"), rs.getString("nome")));
			}

			ConexaoFactory.close(connection, stmt, rs);
			System.out.println("Registro(s) recuperado(s) com sucesso");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void updateLowerCase() {
		String sql = "select * from devdojo.comprador";
		Connection connection = ConexaoFactory.getConexao();
		List<Comprador> lsComprador = new ArrayList<>();

		try {
			DatabaseMetaData dbmd = connection.getMetaData();

			Statement stmt = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
			ResultSet rs = stmt.executeQuery(sql);
			System.out.println(dbmd.updatesAreDetected(ResultSet.TYPE_SCROLL_INSENSITIVE));
			System.out.println(dbmd.insertsAreDetected(ResultSet.TYPE_SCROLL_INSENSITIVE));
			System.out.println(dbmd.deletesAreDetected(ResultSet.TYPE_SCROLL_INSENSITIVE));

			while (rs.next()) {
				rs.updateString("nome", rs.getString("nome").toUpperCase());
//				rs.cancelRowUpdates();
				rs.updateRow();

//				if(rs.rowUpdated()) {
//					System.out.println("Linha atualizada?");
//				}
			}

//			rs.beforeFirst();
//			while(rs.next()) {
//				System.out.println(rs.getString("nome"));
//			}

			rs.absolute(2);
			String nome = rs.getString("nome");
			rs.moveToInsertRow();
			System.out.println(nome);
			System.out.println(rs.getString("nome"));
			rs.updateString("nome", nome.toLowerCase());
			rs.updateString("cpf", "777.777.777-77");
			rs.insertRow();
			rs.moveToCurrentRow();
			System.out.println(rs.getString("nome") + " row: " + rs.getRow());

			rs.absolute(7);
			rs.deleteRow();

			ConexaoFactory.close(connection, stmt, rs);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
