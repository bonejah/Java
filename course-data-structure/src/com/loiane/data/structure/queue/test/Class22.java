package com.loiane.data.structure.queue.test;

import com.loiane.data.structure.queue.Queue;

public class Class22 {
	
	public static void main(String[] args) {
		Queue<Integer> queue = new Queue<>();
		queue.queue(3);
		queue.queue(2);
		queue.queue(1);
		System.out.println(queue);
		System.out.println(queue.pop());
		System.out.println(queue.pop());
		System.out.println(queue);
	}

}
