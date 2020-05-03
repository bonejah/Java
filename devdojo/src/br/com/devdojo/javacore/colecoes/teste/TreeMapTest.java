package br.com.devdojo.javacore.colecoes.teste;

import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

import br.com.devdojo.javacore.colecoes.classes.Consumidor;

public class TreeMapTest {

	public static void main(String[] args) {
		NavigableMap<String, String> map = new TreeMap<>();
		map.put("A", "Letra A");
		map.put("B", "Letra B");
		map.put("C", "Letra C");
		map.put("D", "Letra D");

		for (Map.Entry<String, String> entry : map.entrySet()) {
			System.out.println(entry.getKey() + " - " + entry.getValue());
		}

		System.out.println(map.headMap("C", true));
		System.out.println(map.pollFirstEntry());
		System.out.println(map.lastEntry());
		System.out.println(map.descendingMap());

		System.out.println("==================================");

		NavigableMap<String, Consumidor> map2 = new TreeMap<>();
		Consumidor consumidor = new Consumidor("Bruno", "12345678");
		Consumidor consumidor2 = new Consumidor("Leticia", "87654321");
		map2.put("Consumidor1", consumidor2);
		map2.put("Consumidor2", consumidor);

		for (Map.Entry<String, Consumidor> entry : map2.entrySet()) {
			System.out.println(entry.getKey() + " - " + entry.getValue());
		}
	}

}
