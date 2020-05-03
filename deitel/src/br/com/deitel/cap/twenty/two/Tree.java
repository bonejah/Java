package br.com.deitel.cap.twenty.two;

class TreeNode<T extends Comparable<T>> {

	// membros de acesso de pacote
	TreeNode<T> leftNode; // no esquerdo
	T data; // valor do no
	TreeNode<T> rightNode; // no direito

	// construtor inicializa os dados e os torna um no de folha
	public TreeNode(T nodeData) {
		data = nodeData;
		leftNode = rightNode = null; // o no nao tem nenhum filho
	}

	// localiza ponto de insercao e insere novo no; ignora os valores duplicados
	public void insert(T insertValue) {
		// insere na subarvore esquerda
		if (insertValue.compareTo(data) < 0) {
			// insere novo TreeNode
			if (leftNode == null)
				leftNode = new TreeNode<T>(insertValue);
			else // continua percorrendo a subarvore a esquerda recursivamente
				leftNode.insert(insertValue);
		}
		// insere na subarvore direita
		else if (insertValue.compareTo(data) > 0) {
			// insere novo TreeNode
			if (rightNode == null)
				rightNode = new TreeNode<T>(insertValue);
			else // continua percorrendo a subarvore a direita recursivamente
				rightNode.insert(insertValue);
		}
	}
}

public class Tree<T extends Comparable<T>> {
	private TreeNode<T> root;

	// construtor inicializa uma Tree de inteiros vazia
	public Tree() {
		root = null;
	}

	// insere um novo no na arvore de pesquisa binaria
	public void insertNode(T insertValue) {
		if (root == null)
			root = new TreeNode<T>(insertValue); // cria o no da raiz
		else
			root.insert(insertValue); // chama o metodo insert
	}

	// inicia percurso de pre-ordem
	public void preorderTraversal() {
		preorderHelper(root);
	}

	// metodo recursivo para realizar percurso na pre-ordem
	private void preorderHelper(TreeNode<T> node) {
		if (node == null)
			return;

		System.out.printf("%s ", node.data); // gera saida de dados do nó
		preorderHelper(node.leftNode); // percorre subarvore esquerda
		preorderHelper(node.rightNode); // percorre subarvore direita
	}

	// inicia percurso na ordem
	public void inorderTraversal() {
		inorderHelper(root);
	}

	// metodo recursivo para realizar percurso na ordem
	private void inorderHelper(TreeNode<T> node) {
		if (node == null)
			return;

		inorderHelper(node.leftNode); // percorre subarvore esquerda
		System.out.printf("%s ", node.data); // gera saida de dados do nó
		inorderHelper(node.rightNode); // percorre subarvore direita
	}
	
	// inicia percurso na pos-ordem
	public void postorderTraversal() {
		postorderHelper(root);
	}
	
	// metodo recursivo para realizar percurso na pos-ordem
	private void postorderHelper(TreeNode<T> node) {
		if(node == null)
			return;
		
		postorderHelper(node.leftNode);
		postorderHelper(node.rightNode);
		System.out.printf("%s ", node.data); // gera saida de dados do nó
	}
}
