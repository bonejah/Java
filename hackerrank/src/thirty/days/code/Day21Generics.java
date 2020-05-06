package thirty.days.code;

public class Day21Generics {
	
//	The letters below are commonly-used generic type parameters:
//
//		E - Element
//		K - Key
//		V - Value
//		N - Number
//		T - Type (e.g.: data type)
//		S,U,V, etc. These are second, third, and fourth types for when T is already in use.

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
