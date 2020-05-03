package operadores;

public class ContandoStrings {
	
	public static void main(String[] args) {
		String h = new String(" hello "); // 2
		String h1 = "hello "; // 0
		String w = "world"; // 1
		
		System.out.println("hello "); // 0
		System.out.println(h1 + "world"); // 1
		System.out.println("Hello " == h1); // 1
	}
	
}
