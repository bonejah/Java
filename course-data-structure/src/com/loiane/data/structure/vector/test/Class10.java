package com.loiane.data.structure.vector.test;

import com.loiane.data.structure.vector.Contact;
import com.loiane.data.structure.vector.VetorObject;

public class Class10 {

	public static void main(String[] args) {
		VetorObject vetor = new VetorObject(3);

		Contact contact1 = new Contact("Contato 1", "1234-5678", "contato1@email.com");
		Contact contact2 = new Contact("Contato 2", "1234-5678", "contato2@email.com");
		Contact contact3 = new Contact("Contato 3", "1234-5678", "contato3@email.com");
		Contact contact4 = new Contact("Contato 1", "1234-5678", "contato1@email.com");

		vetor.addElement(contact1);
		vetor.addElement(contact2);
		vetor.addElement(contact3);
		System.out.println(vetor);

		int pos = vetor.find(contact4);
		if (pos > -1) {
			System.out.println("Elemento existe no vetor");
		} else {
			System.out.println("Elemento não existe no vetor");
		}

	}

}
