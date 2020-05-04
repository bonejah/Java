package thirty.days.code;

public class Day21Generics {

	public static void main(String[] args) {
		Object[] array = {1, 2, 3, "Hello", "World", false, 'a'};
		printArray(array);
	}

	public static <T> void printArray(T[] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.println(array[i]);
		}
	}

}
