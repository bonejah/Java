package com.loiane.data.structure.queue.test;

import com.loiane.data.structure.queue.Queue;

public class Class21 {
	
	public static void main(String[] args) {
		Queue<Integer> queue = new Queue<>();
		System.out.println("Queue is empty? " + (queue.isEmpty() ? "TRUE" : "FALSE"));
		
		queue.queue(3);
		queue.queue(2);
		queue.queue(1);
		System.out.println("Queue is empty? " + (queue.isEmpty() ? "TRUE" : "FALSE"));
		System.out.println(queue);	
	}

}
