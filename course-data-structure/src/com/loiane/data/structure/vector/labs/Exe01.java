package com.loiane.data.structure.vector.labs;

import com.loiane.data.structure.vector.Lista;

public class Exe01 {
	
	public static void main(String[] args) {
		Lista<String> list = new Lista<String>(5);
		list.addElement("A");
		list.addElement("B");
		list.addElement("C");		
		System.out.println(list.contains("C"));
	}

}
