package com.loiane.data.structure.vector.test;

import com.loiane.data.structure.vector.Lista;

public class Class11 {

	public static void main(String[] args) {
		Lista<String> lista = new Lista<String>(1);
		lista.addElement("1");
		lista.addElement("2");
		System.out.println(lista);
	}

}
