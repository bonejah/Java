package br.com.devdojo.javacore.wrapper.teste;

public class WrapperTest {
	
	public static void main(String[] args) {
		byte bytePrimitive =1;
		short shortPrimitive = 1;
		int intPrimitive = 1;
		long longPrimitive = 1l;
		double doublePrimitive = 1;
		float floatPrimitive = 1f;
		char charPrimitive = 'A';
		boolean booleanPrimitive = false;
		
		Byte byteWrapper = 1;
		Short shortWrapper = 1;
		Integer intWrapper = new Integer("10");
		Long longWrapper = Long.valueOf(7l);
		Double doubleWrapper = 1d;
		Float floatWrapper = new Float("1");
		Character charWrapper = new Character('A');
		Boolean booleanWrapper = new Boolean("true");
		
		String valor = "10";
		Float f = Float.parseFloat(valor);
		System.out.println(f);
		
		System.out.println(Character.isDigit('1'));
		System.out.println(Character.isLetter('w'));
		
		
		
		
	}

}
