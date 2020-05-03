import java.util.Base64;

public class Base64Example {

	public static void main(String[] args) {
		String password = "senha";
		System.out.println(password);

		byte[] passwordEncoded = Base64.getEncoder().encode(password.getBytes());
		System.out.println("Valor em bytes: " + passwordEncoded);

		String passStringEncoded = new String(passwordEncoded);
		System.out.println("Valor em string: " + passStringEncoded);

		byte[] passwordDecoded = Base64.getDecoder().decode(passStringEncoded);
		System.out.println("Valor em bytes: " + passwordDecoded);

		String passStringDecoded = new String(passwordDecoded);
		System.out.println("Valor em string: " + passStringDecoded);
		
		

	}

}
