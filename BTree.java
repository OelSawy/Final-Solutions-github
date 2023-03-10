import java.util.Stack;

class Node {

	public Comparable data;
	public Node left, right;

	public Node(Comparable data) {
		this(data, null, null);
	}

	public Node(Comparable data, Node left, Node right) {

		this.data = data;
		this.left = left;
		this.right = right;
	}
}

class BTree {
	public Node root;

	public BTree() {
		root = null;
	}

	public void add(Comparable key) {
		Node current = root, parent = null;
		while (current != null) {
			if (key.compareTo(current.data) < 0) {
				parent = current;
				current = current.left;
			}

			else {
				parent = current;
				current = current.right;
			}
		}

		if (parent == null)
			root = new Node(key);

		else {
			if (key.compareTo(parent.data) < 0)
				parent.left = new Node(key);

			else
				parent.right = new Node(key);
		}
	}

	public boolean delete(Comparable key) {
		if (root == null)
			return false;
		Node current = root;
		Node parent = root;
		boolean right = true;
		// searching for the node to be deleted
		while (key.compareTo(current.data) != 0) {
			if (key.compareTo(current.data) < 0) {
				right = false;
				parent = current;
				current = current.left;
			} else {
				right = true;
				parent = current;
				current = current.right;
			}
			if (current == null)
				return false;
		}

		Node substitute = null;
		// case 1: Node to be deleted has no children
		if (current.left == null && current.right == null)
			substitute = null;

		// case 2: Node to be deleted has one child
		else if (current.left == null)
			substitute = current.right;
		else if (current.right == null)
			substitute = current.left;
		else // case 3: Node to be deleted has two children
		{
			Node successor = current.right;
			Node successorParent = current;
			// searching for the inorder successor of the node to be deleted
			while (successor.left != null) {
				successorParent = successor;
				successor = successor.left;
			}
			substitute = successor;
			if (successorParent == current) {
				if (successor.right == null)
					successorParent.right = null;
				else
					successorParent.right = successor.right;
			} else {
				if (successor.right == null)
					successorParent.left = null;
				else
					successorParent.left = successor.right;
			}
			successor.right = current.right;
			successor.left = current.left;
			substitute = successor;
		} // case 3 done
		if (current == root) // Replacing the deleted node
			root = substitute;
		else if (right)
			parent.right = substitute;
		else
			parent.left = substitute;
		return true;

	}

	public void displayTree() {
		java.util.Stack<Node> globalStack = new java.util.Stack<Node>();
		globalStack.push(root);
		int nBlanks = 32;
		boolean isRowEmpty = false;
		System.out.println(
				"......................................................");
		while (isRowEmpty == false) {
			java.util.Stack<Node> localStack = new java.util.Stack<Node>();
			isRowEmpty = true;

			for (int j = 0; j < nBlanks; j++)
				System.out.print(' ');

			while (globalStack.isEmpty() == false) {
				Node temp = globalStack.pop();
				if (temp != null) {
					System.out.print(temp.data);
					localStack.push(temp.left);
					localStack.push(temp.right);

					if (temp.left != null ||
							temp.right != null)
						isRowEmpty = false;
				} else {
					System.out.print("--");
					localStack.push(null);
					localStack.push(null);
				}
				for (int j = 0; j < nBlanks * 2 - 2; j++)
					System.out.print(' ');
			} // end while globalStack not empty
			System.out.println();
			nBlanks /= 2;
			while (localStack.isEmpty() == false)
				globalStack.push(localStack.pop());
		} // end while isRowEmpty is false
		System.out.println(
				"......................................................");
	}

	public Node search(Comparable item) {
		return search(this.root, item);
	}

	public Node search(Node n, Comparable item) {
		if (n == null) {
			return null;
		} else {
			if (item == n.data) {
				return n;
			} else if (search(n.right, item) == null && search(n.left, item) == null) {
				return null;
			} else if (search(n.right, item) == null) {
				return search(n.left, item);
			} else {
				return search(n.right, item);
			}
		}
	}

	public boolean heapOrdered() {
		return heapOrdered(this.root);
	}

	public boolean heapOrdered(Node n) {
		return ((int) n.data) == maxBranch(n);
	}

	public int maxBranch(Node n) {
		if (n == null) {
			return 0;
		} else {
			return Math.max((int) n.data, Math.max(maxBranch(n.left), maxBranch(n.right)));
		}
	}

	public LinkList path(int key) {
		LinkList l = new LinkList();
		return path(l, this.root, key);
	}

	public LinkList path(LinkList l, Node n, int key) {
		if (n == null) {
			return null;
		}
		if ((int) n.data == key) {
			l.insertLast(key);
		} else {
			l.insertLast(n.data);
			if (key > (int) n.data) {
				return path(l, n.right, key);
			} else {
				return path(l, n.left, key);
			}
		}
		return l;
	}

	public static void levelOrder(Node root) {
		Stack<Object> s = new Stack<Object>();
		s.push(root);
		while (!s.isEmpty()) {
			Node node = (Node) s.pop();
			System.out.print(" " + node.data);
			if (node.left != null)
				s.push(node.left);
			if (node.right != null)
				s.push(node.right);
		}
	}

	public int getWidth() {
		return getWidth(this.root);
	}

	public int getWidth(Node n) {
		if (n == null) {
			return 0;
		}

	}

	public static void main(String[] args) {
		BTree b = new BTree();
		b.add(9);
		b.add(5);
		b.add(14);
		b.add(4);
		b.add(8);
		b.add(16);
		b.add(15);
		b.add(30);
		b.displayTree();
		levelOrder(b.root);
	}

}