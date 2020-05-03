package com.loiane.data.structure.vector.labs;

import com.loiane.data.structure.vector.Lista;

public class Exe4 {
	
	public static void main(String[] args) {
		Lista<String> lista = new Lista<String>(5);
		lista.addElement("A");
		lista.addElement("B");
		lista.addElement("A");
		System.out.println(lista.get(0));
	}

}
