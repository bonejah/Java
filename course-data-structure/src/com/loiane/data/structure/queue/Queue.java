package com.loiane.data.structure.queue;

import com.loiane.data.structure.base.StructureBase;

public class Queue<T> extends StructureBase<T>{

	public Queue() {
		super();
	}
	
	public Queue(int capacity) {
		super(capacity);
	}
	
	public void queue(T element) {
		this.add(element);
	}
	
	public T peek() {
		if (this.isEmpty()) {
			return null;
		}
		
		return this.elements[0];
	}
	
	public T pop() {
		final int POS = 0;
		
		if (this.isEmpty()) {
			return null;
		}
		
		T elementToRemove = this.elements[POS];
		this.remove(POS);
		return elementToRemove;
	}
	
}
