package com.loiane.data.structure.vector.test;

import java.util.ArrayList;

public class Class12 {

	public static void main(String[] args) {
		ArrayList<String> aList = new ArrayList<String>();
		aList.add("Me");
		aList.add("Irene");
		System.out.println(aList);
		
		aList.add(0, "Sonic");
		System.out.println(aList);
		
		boolean exists = aList.contains("Sonic");
		System.out.println(exists ? "Element exists" : "Element not exists");
		
		int pos = aList.indexOf("Me");
		if (pos > -1) {
			System.out.println("Element exists in position: " + pos);
		} else {
			System.out.println("Element not exists " + pos);
		}
		
		System.out.println(aList.get(2));
		
		aList.remove(0);
		System.out.println(aList);
		
		System.out.println(aList.size());
		
	}

}
