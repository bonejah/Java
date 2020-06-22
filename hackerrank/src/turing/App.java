package turing;

import java.util.Map;

public class App {

	public static void main(String[] args) {
		Dog dog = new Dog();
		dog.makeNoise();
		dog.move();
		dog.wagTail();
//		dog.fetch();
		
		Canine canine = new Dog();
		canine.makeNoise();
		canine.move();
		canine.wagTail();
//		canine.fetch();
		
		Animal animal = new Dog();
		animal.makeNoise();
		animal.move();
//		animal.wagTail();
//		animal.fetch();
		
		 int mask = 0x000F;
	        int value = 0x2222;
	        System.out.println(value & mask);
		
		
	}
}
