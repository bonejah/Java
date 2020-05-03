package br.com.devdojo.javacore.concorrencia.teste;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ConcorrenciaDeColecoesTest {

	public static void main(String[] args) {
		// ConcurrentHashMap
		// ConcurrentLinkedDeque
		// ConcurrentLinkedQueue
		// ConcurrentSkipListMap
		// ConcurrentSkipListSet
		
		Map<String, String> map = new HashMap<>();
		map.put("1", "1");
		map.put("1", "2");
		System.out.println(map.get("1"));
		
		ConcurrentHashMap<String, String> map2 = new ConcurrentHashMap<>();
		map2.put("1", "1");
		map2.putIfAbsent("1", "2");
		System.out.println(map2.get("1	"));
	}

}
