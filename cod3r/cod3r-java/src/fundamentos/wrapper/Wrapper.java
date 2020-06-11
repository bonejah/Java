package fundamentos.wrapper;

public class Wrapper {
	
	public static void main(String[] args) {
		
//		Scanner entrada = new Scanner(System.in);
		
		Byte b = 100;
		Short s = 1000;
//		Integer i = Integer.parseInt(entrada.nextLine());
		Integer i = 1000;;
		Long l = 100000L;
		
		System.out.println(b.byteValue());
		System.out.println(s.toString());
		System.out.println(i);
		System.out.println(l / 3);
		
		Float f = 123.0F;
		System.out.println(f);
		
		Double d = 1234.5678;
		System.out.println(d);
		
		Boolean bol = Boolean.parseBoolean("true");
		System.out.println(bol);
		System.out.println(bol.toString().toUpperCase());
		
		Character c = '#';
		System.out.println(c + "...");
		
	}

}
