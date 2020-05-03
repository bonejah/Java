package com.loiane.data.structure.vector.test;

import com.loiane.data.structure.vector.Vetor;

public class Class9 {

	public static void main(String[] args) {
		Vetor vetor = new Vetor(1);
		vetor.addElement("B");
		vetor.addElement("C");
		vetor.addElement("E");
		vetor.addElement("F");
		vetor.addElement("G");
		System.out.println(vetor);
		
		vetor.remove(1);
		System.out.println(vetor);
	}

}
