package com.loiane.data.structure.vector;

public class VetorObject {

	private Object[] elements;
	private int size;

	public VetorObject(int capacity) {
		this.elements = new Object[capacity];
		this.size = 0;
	}

	public boolean addElement(Object element) {
		increaseSize();
		
		if (this.size < this.elements.length) {
			this.elements[this.size] = element;
			this.size++;
			return true;
		}

		return false;
	}

	public boolean addElement(int position, String element) {
		if (!(position >= 0 && position < this.size)) {
			throw new IllegalArgumentException("Invalid position!");
		}
		
		increaseSize();
		
		for (int i = this.size - 1; i >= position; i--) {
			this.elements[i + 1] = this.elements[i];
		}
		
		this.elements[position] = element;
		this.size++;
		return true;
	}
	
	private void increaseSize() {
		if (this.size == this.elements.length) {
			Object [] newElements = new Object [this.elements.length * 2];
			
			for (int i = 0; i < this.elements.length; i++) {
				newElements[i] = this.elements[i];
			}
			
			this.elements = newElements;
		}
	}

	public void remove(int position) {
		if (!(position >= 0 && position < this.size)) {
			throw new IllegalArgumentException("Invalid position!");
		}
		
		for (int i = position; i < this.size -1; i++) {
			this.elements[i] = this.elements[i + 1];
		}
		
		this.size--;
	}

	public Object find(int position) {
		if (!(position >= 0 && position < this.size)) {
			throw new IllegalArgumentException("Invalid position!");
		}

		return this.elements[position];
	}

	public int find(Object element) {
		for (int i = 0; i < size; i++) {
			if (this.elements[i].equals(element)) {
				return i;
			}
		}

		return -1;
	}

	public int length() {
		return this.size;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("[");

		for (int i = 0; i < this.size - 1; i++) {
			sb.append(this.elements[i]);
			sb.append(", ");
		}

		if (this.size > 0) {
			sb.append(this.elements[this.size - 1]);
		}

		sb.append("]");

		return sb.toString();
	}

}
