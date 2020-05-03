package com.loiane.data.structure.base;

public class StructureBase<T> {

	protected T[] elements;
	protected int size;

	@SuppressWarnings("unchecked")
	public StructureBase(int capacity) {
		this.elements = (T[]) new Object[capacity];
		this.size = 0;
	}

	public StructureBase() {
		this(10);
	}

	protected boolean add(T element) {
		increaseSize();

		if (this.size < this.elements.length) {
			this.elements[this.size] = element;
			this.size++;
			return true;
		}

		return false;
	}

	protected boolean add(int position, T element) {
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

	@SuppressWarnings("unchecked")
	private void increaseSize() {
		if (this.size == this.elements.length) {
			T[] newElements = (T[]) new Object[this.elements.length * 2];

			for (int i = 0; i < this.elements.length; i++) {
				newElements[i] = this.elements[i];
			}

			this.elements = newElements;
		}
	}

	public int size() {
		return this.size;
	}
	
	protected void remove(int position) {
		if (!(position >= 0 && position < this.size)) {
			throw new IllegalArgumentException("Invalid position!");
		}

		for (int i = position; i < this.size - 1; i++) {
			this.elements[i] = this.elements[i + 1];
		}

		this.size--;
	}
	
	public boolean isEmpty() {
		return this.size == 0;
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
