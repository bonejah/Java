package br.com.devdojo.javacore.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExpressoesRegularesTest {

	public static void main(String[] args) {
		
		// \d => busca todos os digitos
		// \D => busca tudo o que não for digito
		// \s => busca por espaços em branco \t \n \f \r
		// \S => busca por caractere que não é branco
		// \w => busca por caracteres de letras a-z A-Z, digitos e _ (underline)
		// \W => busca por tudo que não for caractere de letras
		// [] => busca o que estiver entre os colchetes
		
		// Quantificadores
		// ? => zero ou uma 
		// * => zero ou mais
		// + => uma ou mais
		// [n, m] => de n até m
		// ()
		// |
		// $
		// ^ => caractere de negação
		// . (coringa)
		// Exemplo: o(v|c)o = ovo, oco / maca(rr|c)ão = macarrão ou macacão
		
		int numeroHex = 0XaFF;
//		String regex = "0[xX]([0-9a-fA-F])+(\\s|$)";
//		String texto = "12 0x 0X 0x01FFABC 0x10G 0x1";
		
//		String regex = "([\\w\\._-])+@([a-zA-Z])+(\\.([a-zA-Z])+)+";
//		String texto = "fulano@hotmail.com, 102Abc@gmail.com, #+@!abrao@mail.br, teste@gmail.com.br, teste@mail.co.com.br";
//		System.out.println("Email válido?: " + "#+@!abrao@mail.br".matches(regex));
		
//		String regex = "\\d{2}/\\d{2}/\\d{2,4}";
//		String texto = "05/10/2010 05/05/2015 1/1/01 01/05/95"; // dd/MM/YYYY
		
		String regex = "proj([^,])*";
		String texto = "proj1.bkp proj1.java, proj1.class, proj1final.java, proj2.bkp, proj3.java, diagrama, texto, foto";
		
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(texto);
		
		System.out.println("Texto: " + texto);
		System.out.println("Indice: 0123456789");
		System.out.println("Expressao: " + matcher.pattern());
		System.out.println("Posicoes encontradas");
		while(matcher.find()) {
			System.out.println("Posicao " + matcher.start() + " " + matcher.group());
		}
		
		System.out.println();
		System.out.println(numeroHex);
		
	}
}
