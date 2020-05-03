package br.com.devdojo.javacore.jdbc.conn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.RowSet;
import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetProvider;

import com.mysql.cj.jdbc.JdbcConnection;

public class ConexaoFactory {

	public static Connection getConexao() {
		String url = "jdbc:mysql://localhost:3306/devdojo?useSSL=false";
		String user = "root";
		String password = "";

		try {
			return DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}
	
	public static JdbcRowSet getRowSetConnection() {
		String url = "jdbc:mysql://localhost:3306/devdojo?useSSL=false";
		String user = "root";
		String password = "";

		try {
			JdbcRowSet jdbcRowSet = RowSetProvider.newFactory().createJdbcRowSet();
			jdbcRowSet.setUrl(url);
			jdbcRowSet.setUsername(user);
			jdbcRowSet.setPassword(password);
			return jdbcRowSet;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}
	
	public static CachedRowSet getRowSetConnectionCached() {
		String url = "jdbc:mysql://localhost:3306/devdojo?useSSL=false&rewriteBatchedStatements=true&relaxAutoCommit=true";
		String user = "root";
		String password = "";

		try {
			CachedRowSet createCachedRowSet = RowSetProvider.newFactory().createCachedRowSet();
			createCachedRowSet.setUrl(url);
			createCachedRowSet.setUsername(user);
			createCachedRowSet.setPassword(password);
			return createCachedRowSet;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}
	
	public static void close(Connection conn) {
		try {
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void close(RowSet rowSet) {
		try {
			if (rowSet != null) {
				rowSet.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void close(Connection conn, Statement stmt) {
		try {
			close(conn);
			
			if (stmt != null) {
				stmt.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void close(Connection conn, Statement stmt, ResultSet rs) {
		try {
			close(conn, stmt);
			
			if (rs != null) {
				rs.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
//	public static void close(Connection conn, PreparedStatement pstmt, ResultSet rs) {
//		try {
//			close(conn);
//			
//			if (pstmt != null) {
//				pstmt.close();
//			}
//			
//			if (rs != null) {
//				rs.close();
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//	}

}
