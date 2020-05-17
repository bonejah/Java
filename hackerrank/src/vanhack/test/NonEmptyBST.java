package vanhack.test;

public class NonEmptyBST<E extends Comparable<E>> implements Tree<E> {

	E data;
	Tree<E> left;
	Tree<E> right;

	public NonEmptyBST(E element) {
		this.data = element;
		this.left = new EmptyBST<E>();
		this.right = new EmptyBST<E>();
	}

	public NonEmptyBST(E element, Tree<E> letfTree, Tree<E> rightTree) {
		this.data = element;
		this.left = letfTree;
		this.right = rightTree;
	}

	@Override
	public boolean isEmpty() {
		return false;
	}

	@Override
	public int cardinality() {
		return 1 + left.cardinality() + right.cardinality();
	}

	@Override
	public boolean member(E element) {
		if (this.data == element) {
			return true;
		} else {
			if (element.compareTo(this.data) < 0) {
				return left.member(element);
			} else {
				return right.member(element);
			}
		}
	}

	@Override
	public NonEmptyBST<E> add(E element) {
		if (this.data == element) {
			return this;
		} else {
			if (element.compareTo(this.data) < 0) {
				return new NonEmptyBST<E>(data, left.add(element), right);
			} else {
				return new NonEmptyBST<E>(data, left, right.add(element));
			}
		}
	}

}
