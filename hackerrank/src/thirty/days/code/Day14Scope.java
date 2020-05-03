package thirty.days.code;

import java.util.Arrays;
import java.util.Scanner;

class Difference {
	private int[] elements;
  	public int maximumDifference;

  	public Difference(int[] a) {
  		this.elements = a;
  	}

	public void computeDifference() {
		this.maximumDifference = 0;
		System.out.println(Arrays.toString(elements));
		
		if (elements.length > 1) {
			for (int i = 0; i < elements.length; i++) {
				int a = elements[i];
				System.out.println("Valor de a: " + a);
				
				for (int j = 0; j < elements.length - 1; j++) {
					int b = elements[j + 1];
					System.out.println("Valor de b: " + b);
					
					int difference = (a - b) * -1;
					if (difference < 0) {
						difference = difference * -1;
					}
					System.out.println("Difference: " + difference);
					
					if ((this.maximumDifference == 0) || (difference > this.maximumDifference)) {
						this.maximumDifference = difference;
					} 
				}
				System.out.println("==============");
			}
		} else {
			this.maximumDifference = elements[0];
		}
	}
} 

public class Day14Scope {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        
        sc.close();

        Difference difference = new Difference(a);
        difference.computeDifference();
        System.out.print(difference.maximumDifference);
    }
}
