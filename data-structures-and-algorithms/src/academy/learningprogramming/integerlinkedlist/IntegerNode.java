package academy.learningprogramming.integerlinkedlist;

/**
 *
 * brunolima on Feb 8, 2021
 * 
 */

public class IntegerNode {

	private Integer value;
	private IntegerNode next;

	public IntegerNode(Integer value) {
		this.value = value;
	}

	public IntegerNode getNext() {
		return next;
	}

	public void setNext(IntegerNode next) {
		this.next = next;

	}

	public Integer getValue() {
		return value;
	}

	public void setValue(Integer value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return value.toString();
	}

}
