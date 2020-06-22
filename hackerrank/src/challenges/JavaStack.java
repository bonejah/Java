package challenges;

import java.util.Scanner;
import java.util.Stack;

public class JavaStack {

	public static void main(String[] args) {
		Parser parser = new Parser();

		Scanner in = new Scanner(System.in);

		while (in.hasNext()) {
			System.out.println(parser.isBalanced(in.next()));
		}

		in.close();
	}

}

class Parser {

	public boolean isBalanced(String st) {        
        Stack<Character> stack = new Stack<Character>();        
        	
    	for (int j = 0; j < st.length(); j++) {
			char charAt = st.charAt(j);
			
			if (charAt == '{' || charAt == '(') {
				stack.push(charAt);
				continue;
			}
			
			if (charAt == '}' && !stack.isEmpty() && stack.peek() == '{') {
				stack.pop();
				continue;
			}
			
			if (charAt == ')' && !stack.isEmpty() && stack.peek() == '(') {
				stack.pop();
				continue;
			}
			
			if (charAt == '}' || charAt == ')') {
				stack.push(charAt);
				continue;
			}
		}
        	
        
        return stack.isEmpty();
    }

}