package practice.java;

public class _42_JavaInheritance {

	public static void main(String args[]) {
		Bird bird = new Bird();
		bird.walk();
		bird.fly();
		bird.sing();

	}
}

class Bird extends Animal {
	void fly() {
		System.out.println("I am flying");
	}
}

class Animal {

	void walk() {
		System.out.println("I am walking");
	}

	void sing() {
		System.out.println("I am singing");
	}

}