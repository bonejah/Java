package br.com.deitel.cap.six;

public class Scope {
	private int x = 1;
	
	public void begin() {
		int x = 5;		
		System.out.printf("local x in method begin is %d\n", x);
		
		userLocalVariable();
		useField();
		userLocalVariable();
		useField();
		
		System.out.printf("\nlocal x in method begin is %d\n", x);
	}

	public void useField() {
		System.out.printf("\nfield x on entering method userField is %d\n", x);
		x *= 10;
		System.out.printf("\nfield x before exiting method userField is %d\n", x);
	}

	public void userLocalVariable() {
		int x = 25;
		System.out.printf("\nlocal x in method userLocalVariable is %d\n", x);
		++x;
		System.out.printf("\nlocal x before existing method userLocalVariable is %d\n", x);		
	}
}
