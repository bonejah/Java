package com.loiane.data.structure.vector;

import java.lang.reflect.Array;

public class Lista<T> {

	private T[] elements;
	private int size;

	public Lista(int capacity) {
		this.elements = (T[]) new Object[capacity];
		this.size = 0;
	}

	public Lista(int capacity, Class<T> classType) {
		this.elements = (T[]) Array.newInstance(classType, capacity);
		this.size = 0;
	}

	public boolean addElement(T element) {
		increaseSize();

		if (this.size < this.elements.length) {
			this.elements[this.size] = element;
			this.size++;
			return true;
		}

		return false;
	}

	public boolean addElement(int position, T element) {
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
			T[] newElements = (T[]) new Object[this.elements.length * 2];

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

		for (int i = position; i < this.size - 1; i++) {
			this.elements[i] = this.elements[i + 1];
		}

		this.size--;
	}
	
	public void remove(T element) {
		int pos = this.find(element);
		
		if (pos > -1) {
			this.remove(pos);
		}
	}
	
	public boolean contains(T element) {
		return find(element) > -1;
	}
	
	public T get(int position) {
		return this.find(position);
	}

	public T find(int position) {
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
	
	public void clear() {
		// option 1 
		this.elements = (T[]) new Object[this.elements.length];
		
		// option 2
//		this.size = 0;
		
		// option3
//		for (int i = 0; i < this.size; i++) {
//			this.elements[i] = null;
//		}
	}
	
	public int length() {
		return this.size;
	}
	
	public int lastIndexOf(T element) {
		int lastPosition = -1;
		
		for (int i = this.size - 1; i >= 0; i--) {
			if (this.elements[i].equals(element)) {
				lastPosition = i;
			}
		}
		
		return lastPosition;
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
