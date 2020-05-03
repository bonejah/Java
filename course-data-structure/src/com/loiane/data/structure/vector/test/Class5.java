package com.loiane.data.structure.vector.test;

import com.loiane.data.structure.vector.Vetor;

public class Class5 {

	public static void main(String[] args) {
		Vetor vetor = new Vetor(3);
		vetor.addElement("element 1");
		vetor.addElement("element 2");
		vetor.addElement("element 3");
		
		System.out.println(vetor.find(2));
	}

}
