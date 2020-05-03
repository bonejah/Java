package br.com.deitel.cap.eleven;

public class UsingChainedExceptions {
	public static void main(String[] args) {
		try {
			method1();
		} catch (Exception exception) {
			exception.printStackTrace();
		}
	}

	public static void method1() throws Exception {
		try {
			method2();
		} catch (Exception exception) {
			throw new Exception("Exception throw in method1", exception);
		}
	}

	public static void method2() throws Exception {
		try {
			method3();
		} catch (Exception exception) {
			throw new Exception("Exception throw in method2", exception);
		}
	}

	public static void method3() throws Exception {
		throw new Exception("Exception throw in method3");
	}
}
