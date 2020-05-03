package metodos;

public class TestaString {

	public static void main(String[] args) {
		String nomeDireto = "Java";
		String nomeIndireto = new String("Java");
		
		char[] nome = new char[] {'J', 'a', 'v', 'a'};
		String nome1 = new String(nome);
		
		StringBuilder sb = new StringBuilder("Java");
		String nome2 = new String(sb);
		
		String nomeNulo = null;
		
		String nomeDaProva = "Certificacao" + " " + "Java";
		String nomeDaProvaComNulo = nomeDaProva + " " + nomeNulo;
		System.out.println(nomeDaProva);
		System.out.println(nomeDaProvaComNulo);
//		System.out.println(nomeNulo.toString());
		
		System.out.println("Certificacao " + 1500);
		System.out.println(1500 + " Certificacao");
		System.out.println(15 + (0 + (0 + " Certificacao")));
		System.out.println(1 + (500 + " Certificacao"));
		
		String caelum = "caelum";
		caelum.toUpperCase();
		System.out.println(caelum);
		caelum = caelum.toUpperCase();
		System.out.println(caelum);
		System.out.println(caelum.charAt(0));
		System.out.println(caelum.charAt(3));
//		System.out.println(caelum.charAt(300));
		System.out.println(caelum.length());
		System.out.println(caelum.isEmpty());
		System.out.println("".isEmpty());
		System.out.println("               Leticia         ".trim());
		System.out.println(caelum.replace('A', 'E'));
		System.out.println(caelum.replace("CAE", "ALU"));
		
		String parseado = "      Quero tirar um certificado oficial de JAVA   ".toUpperCase().trim();
		System.out.println(parseado);
		
		String java = "Java";
		System.out.println(java.substring(1));
//		System.out.println(java.substring(-1));
		System.out.println(java.substring(0, 4));
		System.out.println(java.substring(0, 3));
//		System.out.println(java.substring(1, 5));
		System.out.println("JAVA".equals(java));
		System.out.println("JAVA".equalsIgnoreCase(java));
		System.out.println("Certificado".compareTo("Arnaldo")); // item 1 depois de item 2 => Resultado positivo
		System.out.println("Certificado".compareTo("Certificado")); // item 1 igual item 2 => Resultado Zero
		System.out.println("Certificado".compareTo("Frécia")); // item 1 antes de item 2 => Resultado negativo
		
		System.out.println("Certificado".compareTo("certificado")); 
		System.out.println("Certificado".compareToIgnoreCase("certificado"));
		
		
		String texto = "Pretendo fazer a prova de certificação de Java!";
		System.out.println(texto.indexOf("Pretendo"));
		System.out.println(texto.indexOf("Pretendia"));
		System.out.println(texto.indexOf("tendo"));
		System.out.println(texto.indexOf("e"));
		System.out.println(texto.indexOf("a"));
		System.out.println(texto.lastIndexOf("a"));
		System.out.println(texto.lastIndexOf("Pretendia"));
		System.out.println(texto.lastIndexOf("e"));
		System.out.println(texto.indexOf("e", 7));
		System.out.println(texto.lastIndexOf("a", 44));
		
		System.out.println(texto.startsWith( "Pretendia"));
		System.out.println(texto.startsWith( "Pretendo"));
		System.out.println(texto.endsWith("Java!"));
		System.out.println(texto.endsWith( "C#"));
	}
	
}
