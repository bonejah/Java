package academy.learningprogramming.heaps;

/**
*
* brunolima on Feb 11, 2021
* 
* Heaps
* 
* - A complete binary tree
* - Must satisfy the head property
* - Max heap: Every parent is greather than or equal to its children
* - Min heap: Every parent is less than or equal to its children
* - Children are added at each level from left to right
* - Usually implemented as arrays
* - The maximum or minimum value will alwayrs be at the root of the tree - the advantage of using a heap
* - Heapify: process of converting a binary tree into a heap - this often has to be done after an insertion or deletion
* - No required ordering between siblings
* 
*/

public class Main {
	
	public static void main(String[] args) {
		Heap heap = new Heap(10);
		
		heap.insert(80);
		heap.insert(75);
		heap.insert(60);
		heap.insert(68);
		heap.insert(55);
		heap.insert(40);
		heap.insert(52);
		heap.insert(67);
		
		heap.printHeap();
		
//		heap.delete(0);
//		heap.delete(5);
//		heap.printHeap();
		
		System.out.println("Peek: " + heap.peek());
		
		heap.sort();
		heap.printHeap();
		
	}

}

