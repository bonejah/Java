package com.loiane.data.structure.queue;

public class QueuePriority<T> extends Queue<T> {
	
	public QueuePriority() {
		super();
	}
	
	public QueuePriority(int capacity) {
		super(capacity);
	}

	@SuppressWarnings("unchecked")
	public void queue(T element) {
		Comparable<T> key = (Comparable<T>) element;

		int i = 0;
		
		for (i = 0; i < this.size; i++) {
			if (key.compareTo(this.elements[i]) < 0) {
				break;
			}
		}
		
		this.add(i, element);
	}

}
