package turing;

public abstract class Canine extends Animal {
	
	public void wagTail() {
		System.out.println("Wagging");
	}

	@Override
	public void move() {
		System.out.println("Run");
	}
	
}
