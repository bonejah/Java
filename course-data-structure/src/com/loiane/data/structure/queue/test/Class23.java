package com.loiane.data.structure.queue.test;

import java.util.LinkedList;
import java.util.Queue;

public class Class23 {
	
	public static void main(String[] args) {
		Queue<Integer> queue = new LinkedList<Integer>();
		
		queue.add(3);
		queue.add(2);
		queue.add(1);
		System.out.println(queue);
		System.out.println(queue.remove());
		System.out.println(queue.remove());
		System.out.println(queue);
	}

}
