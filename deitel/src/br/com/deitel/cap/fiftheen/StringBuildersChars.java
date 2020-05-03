package br.com.deitel.cap.fiftheen;

public class StringBuildersChars {
	public static void main(String[] args) {
		StringBuilder builder = new StringBuilder("hello there");

		System.out.printf("builder = %s\n", builder.toString());
		System.out.printf("Character at 0: %s\nCharacter at 4: %s\n\n", builder.charAt(0), builder.charAt(4));

		char[] charArray = new char[builder.length()];
		builder.getChars(0, builder.length(), charArray, 0);
		System.out.print("The character are: ");

		for (char character : charArray) {
			System.out.print(character);
		}

		builder.setCharAt(0, 'H');
		builder.setCharAt(6, 'T');
		System.out.printf("\n\nbuilder = %s", builder.toString());

		builder.reverse();
		System.out.printf("\n\nbuilder = %s", builder.toString());
	}
}
