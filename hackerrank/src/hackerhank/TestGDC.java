package hackerhank;

public class TestGDC {

	// Greatest Common Divisor
	public static void main(String[] args) {
		int[] arr = { 2, 4, 6, 8, 10 };
//		int[] arr = { 2, 3, 4, 5, 6 };
//		int n1 = 54;
//		int n2 = 24;	

		int result = arr[0];
		for (int i = 0; i < arr.length; i++) {
			result = gdc(result, arr[i]);
		}

		System.out.println(result);
	}
	
	// Using Euler algorithm 
	private static int gdc(int n1, int n2) {
		while (n2 != 0) {
			int rest = n1 % n2;
			n1 = n2;
			n2 = rest;
		}
		return n1;
	}

}
