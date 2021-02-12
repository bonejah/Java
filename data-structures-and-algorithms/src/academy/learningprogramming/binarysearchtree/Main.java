package academy.learningprogramming.binarysearchtree;

/**
*
* brunolima on Feb 11, 2021
* 
*
* Tree
* 
* - Every item in the tree is a node 
* 
* - The node at the top of the tree is the root
* 
* - Every non-root node has one and only one parent
* 
* - A leaf node has no children
* 
* - A singleton tree has only one node - the root
*
* Binary Tree
* 
* - Every node has 0, 1 or 2 children
* 
* - Children are referred to as left child and right child
* 
* - In practice, we use binary search trees
* 
* Binary Search Tree (BST)
* 
* - Can perform insertions, deletions, and retrievals in O9logn) time
* 
* - The left child always has a smaller value than its parent
* 
* - The right child always has a larger value than its parent
* 
* - This means everything to the left of the root is less than the value of the root, and
* everything to the right of the root is greater than the valyue of the root
* 
* - Because of that we can do a binary search
* 
* TreeNode
* 
* Example:
* 
* Pre-order: 25(root), 20, 15, 22, 27, 26, 30, 29, 32
* In-order:  15, 20, 22, 25(root), 26, 27, 29, 30, 32
* Post-order: 15, 22, 20, 26, 29, 32, 30, 27, 25(root) 
* 
*/

public class Main {
	
	public static void main(String[] args) {
		Tree intTree = new Tree();
		intTree.insert(25);
		intTree.insert(20);
		intTree.insert(15);
		intTree.insert(27);
		intTree.insert(30);
		intTree.insert(29);
		intTree.insert(26);
		intTree.insert(22);
		intTree.insert(32);
		intTree.insert(17);
		
//		System.out.println("Printing traverserInOrder");
//		intTree.traverseInOrder();
//		System.out.println();
		
//		System.out.println("Get Tree 32: " + intTree.get(32));
//		System.out.println("Get Tree 25: " + intTree.get(25));
		
//		System.out.println("Min: " + intTree.min());
//		System.out.println("Max: " + intTree.max());
		
//		System.out.println("Printing traverserInOrder");
//		intTree.traverseInOrder();
//		System.out.println();
		
//		intTree.delete(15);
//		intTree.delete(27);
		
		System.out.println("Printing traverserInOrder");
		intTree.traverseInOrder();
		System.out.println();
		
		System.out.println("Printing traverserPreOrder");
		intTree.traversePreOrder();
		System.out.println();
		
	}

}

