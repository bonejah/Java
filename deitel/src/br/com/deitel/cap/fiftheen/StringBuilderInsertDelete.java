package br.com.deitel.cap.fiftheen;

public class StringBuilderInsertDelete {
	public static void main(String[] args) {
		Object objectRegf = "hello";
		String string = "goodbye";
		char[] charArray = { 'a', 'b', 'c', 'd', 'e', 'f' };
		boolean booleanValue = true;
		char characterValue = 'K';
		int integerValue = 7;
		long longValue = 10000000;
		float floatValue = 2.5f;
		double doubleValue = 33.333;

		StringBuilder builder = new StringBuilder();

		builder.insert(0, objectRegf);
		builder.insert(0, " ");
		builder.insert(0, string);
		builder.insert(0, " ");
		builder.insert(0, charArray);
		builder.insert(0, " ");
		builder.insert(0, charArray, 3, 3);
		builder.insert(0, " ");
		builder.insert(0, booleanValue);
		builder.insert(0, " ");
		builder.insert(0, characterValue);
		builder.insert(0, " ");
		builder.insert(0, integerValue);
		builder.insert(0, " ");
		builder.insert(0, longValue);
		builder.insert(0, " ");
		builder.insert(0, floatValue);
		builder.insert(0, " ");
		builder.insert(0, doubleValue);

		System.out.printf("builder after inserts:\n%s\n\n", builder.toString());
		
		builder.deleteCharAt(10);
		builder.delete(2, 6);
		
		System.out.printf("builder after deletes:\n%s\n", builder.toString());
	}
}
