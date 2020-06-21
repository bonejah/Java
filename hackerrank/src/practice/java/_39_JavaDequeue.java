package practice.java;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Scanner;

public class _39_JavaDequeue {
	
	 public static void main(String[] args) {
		 HashMap<Integer, Integer> map = new HashMap<>();
		 Deque<Integer> deque = new ArrayDeque<>();

		 Scanner in = new Scanner(System.in);
         int n = in.nextInt();
         int m = in.nextInt();
         int max = map.size();

         for (int i = 0; i < n; i++) {
             /* Remove old value if necessary */
        	 if (i >= m) {
        		 int old = deque.remove();
        		 
        		 if (map.get(old) == 1) {
        			 map.remove(old);
        		 } else {
        			 map.put(old, map.get(old) - 1);
        		 }
        	 }
        	 
        	 /* Add new value */
        	 int num = in.nextInt();
        	 deque.add(num);
        	 map.merge(num, 1, Integer::sum);
        	 
        	 max = Math.max(max, map.size());
        	 
        	 /* If all integers are unique, break out of loop*/
        	 if (max == 0) break;
         }
         
         in.close();
         System.out.println(max);
     }

}
