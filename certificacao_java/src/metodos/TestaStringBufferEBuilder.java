package metodos;

import modelo.Carro;

public class TestaStringBufferEBuilder {

	public static void main(String[] args) {
		StringBuffer sb = new StringBuffer("Caelum");
		sb.append(" - ");
		sb.append("Ensino e Inovação");
		System.out.println(sb);
		
		StringBuffer sb2 = new StringBuffer(50);
		System.out.println(sb2.toString());
		
		StringBuffer sb3 = new StringBuffer(sb);
		sb3.append(" e Alura e Casa do Código");
		System.out.println(sb3);
		
		
		StringBuilder sb1 = new StringBuilder("Caelum");
		sb1.append(" - ");
		sb1.append("Ensino e Inovação");
		System.out.println(sb1);
		
		StringBuilder sb21 = new StringBuilder(50);
		System.out.println(sb21.toString());
		
		StringBuilder sb31 = new StringBuilder(sb);
		sb31.append(" e Alura e Casa do Código");
		sb31.append('X');
		sb31.append(sb);
		sb31.append(new Carro());
		System.out.println(sb31);
		
		StringBuilder sb4 = new StringBuilder("Caelum - Inovação");
		sb4.insert(9, "Ensino e ");
		System.out.println(sb4);
		sb4.delete(6, 15);
		System.out.println(sb4);
		
		StringBuffer sb5 = new StringBuffer("Bruno").reverse();
		System.out.println(sb5);
		
		StringBuilder sb6 = new StringBuilder("Caelum - E Ensino");
		System.out.println(sb6.substring(6, 15));
		System.out.println(sb6.subSequence(6, 15));
		System.out.println(sb6);
		
	}
	
}
