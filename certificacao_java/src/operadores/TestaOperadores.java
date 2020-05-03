package operadores;

import java.util.ArrayList;
import java.util.List;

public class TestaOperadores {

	public static void main(String[] args) {
		 long idade = 15 ;
		 
		 // byte -> short -> int  -> long
		 // float -> double
		 // char
		 
		 int a = 10;
		 long b = 20;
		 short c = 3;
		 char h = 65;
		 
		 byte d = 4;
//		 d = c;
		 
		 double e = 30.0;
		 float f = 40.3f;
		 f = a;
		 f = b;
		 f = c;
		 f = d;

		 float g = 40.3f;
		 g = a;
		 g = b;
		 g = c;
		 g = d;
		 
		 ArrayList<String> lista = new ArrayList<String>();
		 ArrayList<String> lista2 = lista;
		 List<String> lista3 = lista2;
		 
	}
	
}
