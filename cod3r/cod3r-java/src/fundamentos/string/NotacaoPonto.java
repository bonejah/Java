package fundamentos.string;

public class NotacaoPonto {

	public static void main(String[] args) {
		String s = "bom dia X";
		
		s = s.toUpperCase();
		System.out.println(s);
		
		s = s.replace("X", "Senhora");
		System.out.println(s);

		s = s.concat("!!!");
		System.out.println(s);
		
		System.out.println("Bruno".toLowerCase());
		
		String y = "Bom dia X".replace("X", "Lele");
		System.out.println(y);
		
	}
}
