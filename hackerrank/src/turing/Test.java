package turing;

public class Test {

	public static void main(String[] args) {
		Subclass s1 = new Subclass();
		s1.foo();

		Super s = new Subclass();

	}

}

class Super {
	private void foo() {
		System.out.println("Super");
	}
}

class Subclass extends Super {
	public void foo() {
		System.out.println("SubClass");
	}
}
