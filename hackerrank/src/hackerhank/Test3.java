package hackerhank;

import java.util.PriorityQueue;

public class Test3 {

	public static void main(String[] args) {
		PriorityQueue<String> toDO = new PriorityQueue<String>();
		System.out.println(toDO.toString());
		toDO.add("dishes");
		System.out.println(toDO.toString());
		toDO.add("laundry");
		System.out.println(toDO.toString());
		toDO.offer("bills");
		System.out.println(toDO.toString());
		
		System.out.println(toDO.size());
		System.out.println(toDO.toString());
		System.out.println(toDO.poll());
		System.out.println(toDO.toString());
		System.out.println(toDO.peek());
		System.out.println(toDO.toString());
		System.out.println(toDO.poll());
		System.out.println(toDO.toString());
		System.out.println(toDO.poll());
		System.out.println(toDO.toString());
	}
}
