package operadores;

public class TestaIncrementoEDecremento {

	public static void main(String[] args) {
		int i = 5;
		System.out.println(i); // imprime 5
		
		System.out.println(" ============ ");
		
		// aplica o depois o decremento
		System.out.println(i--);
		
		// aplica o depois o incremento
		System.out.println(i++);
		
		System.out.println(" ============ ");
		
		// aplica antes o incremento
		System.out.println(++i); 
		
		// aplica antes o decremento
		System.out.println(--i);
		
		System.out.println(" ============ ");
		
		i += 2;
		System.out.println(i);
		
		i -= 2;
		System.out.println(i);
		
		i *= 2;
		System.out.println(i);
		
		i /= 2;
		System.out.println(i);
		
		i %= 2;
		System.out.println(i);
		
		System.out.println(" ============ ");
		
		byte b = 10;
		b += 200;
		System.out.println(b);
		
		System.out.println(" ============ ");
		
		int a = 10;
		a += ++a + a + ++a;
//		a = a + ++a + a + ++a;
//		a = 10 + ++a + a + ++a;
//		a = 10 + 11 + a + ++a;
//		a = 10 + 11 + 11 + ++a;
//		a = 10 + 11 + 11 + 12;
		System.out.println(a); // 44
		
	}
}
