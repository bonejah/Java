package com.loiane.data.structure.queue.test;

import com.loiane.data.structure.queue.QueuePriority;

public class Class24 {
	
	public static void main(String[] args) {
		QueuePriority<Integer> queue = new QueuePriority<Integer>();
		queue.queue(1);
		queue.queue(3);
		queue.queue(2);
		System.out.println(queue);
	}

}
