import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class SimpleMD5Example {
	
	public static void main(String[] args) {
		String passwordToHash = "password";
		String generatedPassword = null;
		
		try {
			// Create MessageDigest instance for MD5
			MessageDigest md = MessageDigest.getInstance("MD5");
			System.out.println(md);
			
			// Add password bytes to digest
			md.update(passwordToHash.getBytes());
			
			// Get the hash's bytes
			byte[] bytes = md.digest();
			System.out.println(bytes.toString());
			
			// This bytes[] has bytes in decimal format
			// Convert it to hexadecimal format
			StringBuilder sb = new StringBuilder();
			
			for (int i = 0; i < bytes.length; i++) {
				sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).toString());
			}
			
			generatedPassword = sb.toString();
			System.out.println(generatedPassword);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
	}

}
