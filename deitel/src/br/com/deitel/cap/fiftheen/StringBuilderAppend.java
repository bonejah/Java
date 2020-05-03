package br.com.deitel.cap.fiftheen;

public class StringBuilderAppend {
	public static void main(String[] args) {
		char[] charArray = { 'a', 'b', 'c', 'd', 'e', 'f' };
		String string = "goodbye";
		boolean booleanValue = true;
		char characterValue = 'Z';
		int integerValue = 7;
		long longValue = 100000000l;
		float floatValue = 2.5f;
		double doubleValue = 33.333;
		Object objectRegf = "hello";

		StringBuilder lastBuilder = new StringBuilder("last builder");
		StringBuilder builder = new StringBuilder();

		builder.append(objectRegf);
		builder.append("\n");
		builder.append(string);
		builder.append("\n");
		builder.append(charArray);
		builder.append("\n");
		builder.append(charArray, 0, 3);
		builder.append("\n");
		builder.append(booleanValue);
		builder.append("\n");
		builder.append(characterValue);
		builder.append("\n");
		builder.append(integerValue);
		builder.append("\n");
		builder.append(longValue);
		builder.append("\n");
		builder.append(floatValue);
		builder.append("\n");
		builder.append(doubleValue);
		builder.append("\n");
		builder.append(lastBuilder);
		builder.append("\n");
		
		System.out.printf("builder contains %s\n", builder.toString());
	}
}
