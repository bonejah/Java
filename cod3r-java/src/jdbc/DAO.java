package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DAO {

	private Connection connection;

	public int incluir(String sql, Object... atributos) {
		try {

			PreparedStatement pstmt = getConnection().prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
			adicionarAtributos(pstmt, atributos);
			
			if (pstmt.executeUpdate() > 0) {
				ResultSet resultado = pstmt.getGeneratedKeys();
				
				if (resultado.next()) {
					return resultado.getInt(1);
				}
			}
			
			return -1;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void close() {
		try {
			getConnection().close();
		} catch (Exception e) {
			
		} finally {
			connection = null;
		}
	}
	
	private void adicionarAtributos(PreparedStatement pstmt, Object[] atributos) throws SQLException {
		int indice = 1;

		for (Object atributo : atributos) {
			if (atributo instanceof String) {
				pstmt.setString(indice, (String) atributo);
			} else if (atributo instanceof Integer) {
				pstmt.setInt(indice, (Integer) atributo);
			}
			
			indice++;
		}
	}
	
	private Connection getConnection() {
		try {
			if (connection != null && !connection.isClosed()) {
				return connection;
			}
		} catch (SQLException e) {

		}

		connection = FabricaConexao.getConnection();
		return connection;
	}

}
