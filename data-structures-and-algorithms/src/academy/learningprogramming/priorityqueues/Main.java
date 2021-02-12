package academy.learningprogramming.priorityqueues;

import java.util.Iterator;
import java.util.PriorityQueue;

/**
*
* brunolima on Feb 12, 2021
* 
*/

public class Main {

	public static void main(String[] args) {
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		
		pq.add(25);
		pq.add(-22);
		pq.add(1343);
		pq.add(54);
		pq.add(0);
		pq.add(-3492);
		pq.add(429);

		Iterator<Integer> iterator = pq.iterator();
		while(iterator.hasNext()) {
			System.out.print(iterator.next());
			System.out.print(", ");
		}
		
//		System.out.println(pq.peek());
//		System.out.println(pq.remove());
//		System.out.println(pq.peek());
//		System.out.println(pq.poll());
//		System.out.println(pq.peek());
//		System.out.println(pq.remove(54));
//		System.out.println(pq.peek());
		
	}
	
}

