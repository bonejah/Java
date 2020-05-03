package br.com.devdojo.javacore.colecoes.teste;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class MapTest {

	public static void main(String[] args) {
//		Map<String, String> map = new HashMap<>(); // Nao garante a ordem de Insercao
		Map<String, String> map = new LinkedHashMap<>(); // Garante a ordem de Insercao
		map.put("teklado", "teclado");
		map.put("mouse", "mouse");
		map.put("vc", "você");
//		map.put("vc", "voce");

		System.out.println("Chaves......................");
		for (String key : map.keySet()) {
			System.out.println(key);
		}

		System.out.println("Valores......................");
		for (String value : map.values()) {
			System.out.println(value);
		}

		System.out.println("INterface Entry......................");
		for (Map.Entry<String, String> entry : map.entrySet()) {
			System.out.println("Chave: " + entry.getKey() + ", valor: " + entry.getValue());
		}
	}

}
