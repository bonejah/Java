package br.com.deitel.cap.twenty;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Set;

public class PropertiesTest {
	public static void main(String[] args) {
		Properties table = new Properties();

		// configura propriedades
		table.setProperty("color", "blue");
		table.setProperty("width", "200");

		System.out.println("After setting properties");
		listProperties(table); // exibe os valores da propriedade

		// substitui o valor da propriedade
		table.setProperty("color", "red");

		System.out.println("After replacing properties");
		listProperties(table); // exibe os valores da propriedade

		saveProperties(table); // salva as propriedades

		table.clear(); // tabela vazia

		System.out.println("After clearing properties");
		listProperties(table); // exibe os valores da propriedade

		loadProperties(table);

		// obtem valor de cor da propriedade
		Object value = table.getProperty("color");

		// verifica se o valor está na tabela
		if (value != null)
			System.out.printf("Property color's value is %s\n", value);
		else
			System.out.println("Property color is not in table");
	}

	private static void loadProperties(Properties table) {
		try {
			FileInputStream input = new FileInputStream("props.dat");
			table.load(input);
			input.close();
			System.out.println("After loading properties");
			listProperties(table);
		} catch (IOException ioException) {
			ioException.printStackTrace();
		}
	}

	@SuppressWarnings("resource")
	private static void saveProperties(Properties table) {
		try {
			FileOutputStream output = new FileOutputStream("props.dat");
			table.store(output, "Sample Properties");
			output.close();
			System.out.println("After saving properties");
			listProperties(table);
		} catch (IOException ioException) {
			ioException.printStackTrace();
		}
	}

	private static void listProperties(Properties table) {
		Set<Object> keys = table.keySet();

		for (Object key : keys)
			System.out.printf("%s\t%s\n", key, table.getProperty((String) key));

		System.out.println();
	}
}
