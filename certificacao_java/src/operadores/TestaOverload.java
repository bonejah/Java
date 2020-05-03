package operadores;

class Overload {
	
	public void metodo(int a) {
		System.out.println("com int");
	}
	
	public void metodo(double b) {
		System.out.println("com double");
	}
	
	public void metodo() {
		System.out.println("sem nada");
	}
	
	public void metodo2(String s) {
		System.out.println("com string");
	}
	
	public void metodo2(Object o) {
		System.out.println("com object");
	}
	
	public void metodo3(String a, int b) {
		System.out.println("String, int");
	}
	
	public void metodo3(int b, String a) {
		System.out.println("int, String");
	} 
	
	public void metodo4 (int a, double b) {
		System.out.println("int, double");
	}
	
	public void metodo4 (double b, int a) {
		System.out.println("double, int");
	}
	
}

public class TestaOverload {

	public static void main(String[] args) {
		new Overload().metodo();
		new Overload().metodo(5);
		new Overload().metodo((short)5);
		new Overload().metodo(5.5);
		new Overload().metodo((float)5.5);
		new Overload().metodo2("guilherme");
		new Overload().metodo2(new Object());
		new Overload().metodo3(5, "Jose");
		new Overload().metodo3("5", 10);
		new Overload().metodo4(5, 5.5);
		new Overload().metodo4(5.5, 5);
//		new Overload().metodo4(5, 5);
	}
}
