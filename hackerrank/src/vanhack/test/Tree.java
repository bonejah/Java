package vanhack.test;

public interface Tree<E extends Comparable<E>> {

	public boolean isEmpty();
	
	public int cardinality();
	
	public boolean member(E element);
	
	public NonEmptyBST<E> add (E element);
	
}
