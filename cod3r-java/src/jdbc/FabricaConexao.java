package jdbc;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class FabricaConexao {

	public static Connection getConnection() {
		try {
			Properties properties = getProperties();
			
			String url = properties.getProperty("banco.url");
			String user = properties.getProperty("banco.user");
			String password = properties.getProperty("banco.password");
			
			return DriverManager.getConnection(url, user, password);
		} catch (SQLException | IOException e) {
			throw new RuntimeException(e);
		}
	}
	
	public static Properties getProperties() throws IOException {
		String pathFile = "/conexao.properties";
		
		Properties properties = new Properties();
		properties.load(FabricaConexao.class.getResourceAsStream(pathFile));
		return properties;
	}
	
}


