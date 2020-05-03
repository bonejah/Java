package com.loiane.data.structure.queue.test;

import com.loiane.data.structure.queue.Queue;

public class Class20 {
	
	public static void main(String[] args) {
		Queue<Integer> queue = new Queue<>();
		queue.queue(1);
		queue.queue(2);
		queue.queue(3);
		System.out.println(queue);	
		
		queue.queue(4);
		System.out.println(queue);	
	}

}
