package practice.java;

import java.util.ArrayList;
import java.util.Scanner;

public class _30_JavaArrayList {
	

	public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        System.out.println("Enter size array main: ");
        int n = scan.nextInt();
                
        /* Save numbers in 2-D ArrayList */
        ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
        for (int row = 0; row < n; row++) {
        	System.out.println("Enter quantity Elements in array index: " + row);
            int d = scan.nextInt();
            
            ArrayList<Integer> list = new ArrayList<>();
            
            for (int col = 0; col < d; col++) {
            	System.out.println("Enter element: ");
                list.add(scan.nextInt());
            }
            
            lists.add(list);
        }
        
        for (int i = 0; i < lists.size(); i++) {
			System.out.println("Printing array of index: " + i);
        	
			StringBuilder sb = new StringBuilder();
			for (int j = 0; j < lists.get(i).size(); j++) {
				if (j < lists.get(i).size() - 1) {
					sb.append(lists.get(i).get(j) + " - ");
				} else {
					sb.append(lists.get(i).get(j));
				}
			}
			
			System.out.print("Elements: " + sb.toString() + "\n\n");
		}
        
        
        
        /* Answer the queries */
        System.out.println("Enter quantity queries: ");
        int q = scan.nextInt();
        
        for (int i = 0; i < q; i++) {
        	System.out.println("Enter index array to be searched: ");
        	int x = scan.nextInt();
        	
            System.out.println("Enter index element: ");
            int y = scan.nextInt();
           
            ArrayList<Integer> list = lists.get(x-1);
            
            if (y <= list.size()) {
                System.out.println(list.get(y-1));
            } else {
                System.out.println("ERROR!");
            }
        }
        
        scan.close();
    }
	
}
