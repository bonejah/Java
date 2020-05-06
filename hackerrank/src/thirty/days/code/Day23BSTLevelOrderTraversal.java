package thirty.days.code;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Day23BSTLevelOrderTraversal {

	static Queue<Node3> queue = new LinkedList<Node3>();

	static void levelOrder(Node3 root) {
		if (root != null) {
			queue.add(root);
		}
		
		while (!queue.isEmpty()) {
			Node3 tree = queue.remove();
			System.out.println(tree.data + " ");
			
			if (tree.left != null) {
				queue.add(tree.left);
			}
			
			if (tree.right != null) {
				queue.add(tree.right);
			}
		}
	}

	public static Node3 insert(Node3 root, int data) {
		if (root == null) {
			return new Node3(data);
		} else {
			Node3 cur;

			if (data <= root.data) {
				cur = insert(root.left, data);
				root.left = cur;
			} else {
				cur = insert(root.right, data);
				root.right = cur;
			}

			return root;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		Node3 root = null;

		while (T-- > 0) {
			int data = sc.nextInt();
			root = insert(root, data);
		}

		levelOrder(root);
	}

}

class Node3 {

	int data;
	Node3 left, right;

	Node3(int data) {
		this.data = data;
		left = right = null;
	}

	@Override
	public String toString() {
		return "Node [data=" + data + ", left=" + left + ", right=" + right + "]\n";
	}

	

}
