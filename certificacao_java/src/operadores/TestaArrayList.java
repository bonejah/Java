package operadores;

import java.util.ArrayList;

public class TestaArrayList {

	public static void main(String[] args) {
		ArrayList<String> nomes = new ArrayList<>();
		nomes.add("Java");
		nomes.add("Java");
		nomes.add("C#");
		
		System.out.println(nomes.contains("Java"));
		System.out.println(nomes.contains("Ruby"));
		
		boolean nomeJavaRemovido = nomes.remove("Java");
		System.out.println(nomeJavaRemovido);
		System.out.println(nomes.contains("Java"));
		
		System.out.println(nomes.size());
		System.out.println(nomes);
		
		Object[] objetos = nomes.toArray();
		System.out.println(objetos);
		for (int i = 0; i < objetos.length; i++) {
			System.out.println(objetos[i]);
		}
		
		String[] nomesArray = nomes.toArray(new String[nomes.size()]);
		System.out.println(nomesArray);
		for (int i = 0; i < nomesArray.length; i++) {
			System.out.println(nomesArray[i]);
		}
		
		ArrayList<String> paises = new ArrayList<String>();
		paises.add("Brasil");
		paises.add("Coreia");
		
		ArrayList<String> tudo = new ArrayList<String>();
		tudo.addAll(paises);
		tudo.addAll(nomes);
		System.out.println(tudo.size());
		System.out.println(tudo);
		System.out.println(tudo.get(2));
		
		tudo.add(0, "Canada");
		System.out.println(tudo);
		System.out.println(tudo.get(2));
	
		tudo.set(0, "Cuba");
		System.out.println(tudo);
		
		int indexOfJava = tudo.indexOf("Java");
		System.out.println(indexOfJava);
		
	}
}
