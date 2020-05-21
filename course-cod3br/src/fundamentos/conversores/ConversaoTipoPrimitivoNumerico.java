package fundamentos.conversores;

public class ConversaoTipoPrimitivoNumerico {

	public static void main(String[] args) {
		double a = 1;
		System.out.println(a);
		
		float b = (float) 1.0;
		System.out.println(b);
		
		int c = 127;
		System.out.println(c);

		byte d = (byte) c;
		System.out.println(d);
		
		double e = 10;
		int f = (int) e;
		System.out.println(f);
	}
	
}
