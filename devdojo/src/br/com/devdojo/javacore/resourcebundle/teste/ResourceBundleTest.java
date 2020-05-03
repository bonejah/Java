package br.com.devdojo.javacore.resourcebundle.teste;

import java.util.Locale;
import java.util.ResourceBundle;

public class ResourceBundleTest {
	
	public static void main(String[] args) {
//		System.out.println(Locale.getDefault());
		ResourceBundle rb = ResourceBundle.getBundle("messages", new Locale("en","US"));
		System.out.println(rb.getString("hello"));
		System.out.println(rb.getString("good.morning"));
		System.out.println(rb.getString("show"));
		
		System.out.println("=========================================");
		
		rb = ResourceBundle.getBundle("messages", new Locale("pt","BR"));
		System.out.println(rb.getString("hello"));
		System.out.println(rb.getString("good.morning"));
		System.out.println(rb.getString("show"));
		
//		Ordem de leitura do properties
//		Locale locale = nre Locale("fr", "CA");
//		ResourceBundle.getBundle("messages", locale);
//		1- messages_fr_CA.properties
//		2- messages_fr.properties
//		3- messages_en_US.properties
//		4- messages_en.properties
//		5- messages.properties
		
	}

}
