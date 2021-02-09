package academy.learningprogramming.stacks;

/**
*
* brunolima on Feb 8, 2021
* 
*/

public class Main {
	
	public static void main(String[] args) {
		
		ArrayStack stack = new ArrayStack(10);
		
		stack.push(new Employee("Bruno", "Lima", 1));
		stack.push(new Employee("Leticia", "Lima", 2));
		stack.push(new Employee("Bianca", "Lima", 3));
		stack.push(new Employee("Matheus", "Lima", 4));
		
		stack.printStack();
		System.out.println();
		
		System.out.println("Peek: " + stack.peek());
		
		System.out.println("Popped: " + stack.pop());
		System.out.println();
		
		stack.printStack();
		System.out.println();
		
		System.out.println("Peek: " + stack.peek());
	}

}

