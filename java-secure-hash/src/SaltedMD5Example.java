import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.SecureRandom;

public class SaltedMD5Example {

	public static void main(String[] args) throws NoSuchAlgorithmException, NoSuchProviderException {
		String passwordToHash = "password";
		byte[] salt = getSalt();

		String securePassword = getSecurePassword(passwordToHash, salt);
		System.out.println(securePassword);

		String regeneratePasswordToVerify = getSecurePassword(passwordToHash, salt);
		System.out.println(regeneratePasswordToVerify);
	}

	private static String getSecurePassword(String passwordToHash, byte[] salt) {
		String generatedPassword = null;

		try {
			// Create MessageDigest instance for MD5
			MessageDigest md = MessageDigest.getInstance("MD5");
//			System.out.println(md);

			// Add password bytes to digest
			md.update(passwordToHash.getBytes());

			// Get the hash's bytes
			byte[] bytes = md.digest();
//			System.out.println(bytes.toString());

			// This bytes[] has bytes in decimal format
			// Convert it to hexadecimal format
			StringBuilder sb = new StringBuilder();

			for (int i = 0; i < bytes.length; i++) {
				sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).toString());
			}

			generatedPassword = sb.toString();
//			System.out.println(generatedPassword);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		
		return generatedPassword;
	}

	private static byte[] getSalt() throws NoSuchAlgorithmException, NoSuchProviderException {
		// Always use a SecureRandom generator
		SecureRandom sr = SecureRandom.getInstance("SHA1PRNG", "SUN");
		
		// Create array for salt
		byte[] salt = new byte[16];
		System.out.println(salt);
		
		// Get a random salt
		sr.nextBytes(salt);
		System.out.println(salt);
		
		// return salt
		return salt;
	}

}
