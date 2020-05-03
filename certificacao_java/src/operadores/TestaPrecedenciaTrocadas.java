package operadores;

public class TestaPrecedenciaTrocadas {

	public static void main(String[] args) {
		int z = 15 * 4 + 1;
		System.out.println(z);
		
		int z1 = 15 * (4 + 1);
		System.out.println(z1);
		
		System.out.println(15 + 0 + " eh cento e cinquenta");
		System.out.println(15 + (0 + " eh cento e cinquenta"));
		
		System.out.println("bruno" + "lima".length());
		System.out.println(("bruno" + "lima").length());
	}
}
