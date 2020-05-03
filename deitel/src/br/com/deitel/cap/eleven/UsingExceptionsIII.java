package br.com.deitel.cap.eleven;

public class UsingExceptionsIII {
	public static void main(String[] args) {
		try {
			method1();
		} catch (Exception exception) {
			System.err.printf("%s\n\n", exception.getMessage());
			exception.printStackTrace();

			StackTraceElement[] traceElements = exception.getStackTrace();
			System.out.println("\nStack trace from getStackTrace()");
			System.out.println("Class\t\t\t\t\t\tFile\t\t\tLine\tMethod");

			for (StackTraceElement stackTraceElement : traceElements) {
				System.out.printf("%s\t", stackTraceElement.getClassName());
				System.out.printf("%s\t", stackTraceElement.getFileName());
				System.out.printf("%s\t", stackTraceElement.getLineNumber());
				System.out.printf("%s\n", stackTraceElement.getMethodName());
			}
		}
	}

	public static void method1() throws Exception {
		method2();
	}

	public static void method2() throws Exception {
		method3();
	}

	public static void method3() throws Exception {
		throw new Exception("Exception throw in method3");
	}
}
