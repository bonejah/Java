package com.loiane.data.structure.vector.test;

import com.loiane.data.structure.vector.Vetor;

public class Class7 {

	public static void main(String[] args) {
		Vetor vetor = new Vetor(10);
		vetor.addElement("B");
		vetor.addElement("C");
		vetor.addElement("E");
		vetor.addElement("F");
		vetor.addElement("G");
		System.out.println(vetor);
		
		vetor.addElement(0, "A");
		System.out.println(vetor);
		
		vetor.addElement(3, "D");
		System.out.println(vetor);
	}

}
