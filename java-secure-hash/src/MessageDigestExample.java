import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MessageDigestExample {
	
	public static void main(String[] args) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		String password = "12345";
		
		MessageDigest md = MessageDigest.getInstance("MD5");
		byte[] messageDigest = md.digest("senha".getBytes("UTF-8"));
		System.out.println(messageDigest);
		
		StringBuilder sb = new StringBuilder();
		
		for (byte b : messageDigest) {
			sb.append(String.format("%02X", 0xFF & b));
		}
		
		System.out.println(sb.toString());
		
		System.out.println("==============================================");
		
		MessageDigest algorithm = MessageDigest.getInstance("SHA-256");
		byte messageDigest2[] = algorithm.digest("senha".getBytes("UTF-8"));
		System.out.println(messageDigest2);

		StringBuilder hexString = new StringBuilder();
		for (byte b : messageDigest2) {
			hexString.append(String.format("%02X", 0xFF & b));
		}
		String senha = hexString.toString();
		
		System.out.println(senha);
	}
	
}
