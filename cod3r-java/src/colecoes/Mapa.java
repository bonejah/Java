package colecoes;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Mapa {

	public static void main(String[] args) {
		Map<Integer, String> usuarios = new HashMap<Integer, String>();

		usuarios.put(1, "Roberto");
		usuarios.put(1, "Ricardo");
		usuarios.put(2, "Rafael");
		usuarios.put(3, "Leticia");
		usuarios.put(4, "Bruno");

		System.out.println(usuarios.size());
		System.out.println(usuarios.isEmpty());
		System.out.println(usuarios);
		System.out.println(usuarios.keySet());
		System.out.println(usuarios.values());
		System.out.println(usuarios.entrySet());
		System.out.println(usuarios.containsKey(1));
		System.out.println(usuarios.containsValue("Ricardo"));
		System.out.println(usuarios.get(1));
		System.out.println(usuarios.remove(1, "Ricardo"));
		System.out.println(usuarios.remove(2));

		for (Integer key : usuarios.keySet()) {
			System.out.println(key);
		}

		for (String value : usuarios.values()) {
			System.out.println(value);
		}

		for (Entry<Integer, String> usuario : usuarios.entrySet()) {
			System.out.println(usuario.getKey() + " - " + usuario.getValue());
		}

	}

}
