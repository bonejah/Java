package br.com.devdojo.javacore.string.teste;

public class StringBuilderTest {
	
	public static void main(String[] args) {
		String s = "Uma frase qualquer";
		StringBuilder sb = new StringBuilder(10);
		sb.append("Uma frase qualquer 2");
		sb.append(" teste");
		System.out.println(sb);
		System.out.println(sb.reverse());
		System.out.println(sb.delete(0, 2));
		System.out.println(sb);
		System.out.println(sb.insert(0, "et"));
	}

}
