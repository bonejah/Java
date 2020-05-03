package br.com.devdojo.javacore.interfacedefault;

public class C extends D implements A, B {
//public class C implements A, B {

	public static void main(String[] args) {
		new C().oi();
	}
	
//	public void oi() {
//		A.super.oi();
//	}
}
