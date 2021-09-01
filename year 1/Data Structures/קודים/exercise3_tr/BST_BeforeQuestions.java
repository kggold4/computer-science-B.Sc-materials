package exercise3_tr;
// ******************* Zvi Mints - zvimints@gmail.com ********************************** //
public class BST_BeforeQuestions
{
	// Root of BST 
	Node root;

	// Constructor 
	BST_BeforeQuestions() {  root = null; } 

	// Returns minimum value in a given  
	// Binary Tree 
	public int returnMin()
	{
		Node current = root;
		while (current.left != null)
			current = current.left;
		return current.data;
	}

	// Returns maximum value in a given  
	// Binary Tree 
	public int returnMax()
	{
		Node current = root;
		while (current.right != null)
			current = current.right;
		return current.data;
	}

	// Returns true iff Node(key) in the  Tree
	public boolean search(int key)
	{
		Node current = root;

		while(current != null)
		{
			if(current.data == key) return true;
			else if(key > current.data ) current = current.right;
			else current = current.left;
		}
		return false;
	}

	/* Compute the "maxDepth" of a tree -- the number of  
	nodes along the longest path from the root node  
    down to the farthest leaf node.*/
	public int getHeight()
	{
		return getHeight(root);	
	}

	public int getHeight(Node current)
	{
		int result = -1;
		if(current != null)
		{
			int LeftHeight = getHeight(current.left);
			int RightHeight = getHeight(current.right);
			result = Integer.max(LeftHeight, RightHeight) + 1;
		}
		return result;
	}
	/* Given a binary tree, print its nodes according to the PreOrder */
	public void PreOrder() // (V,L,R)
	{
		PreOrder(root);
	}
	public void PreOrder(Node current)
	{
		if(current != null)
		{
			System.out.print(current.data + " " );
			PreOrder(current.left);
			PreOrder(current.right);
		}
	}
	/* Given a binary tree, print its nodes according to the InOrder */
	public void InOrder() // (L,V,R)
	{
		InOrder(root);
	}
	public void InOrder(Node current)
	{
		if(current != null)
		{
			InOrder(current.left);
			System.out.print(current.data + " " );
			InOrder(current.right);
		}
	}
	/* Given a binary tree, print its nodes according to the PostOrder */
	public void PostOrder() // (L,R,V)
	{
		PostOrder(root);
	}
	public void PostOrder(Node current)
	{
		if(current != null)
		{
			PostOrder(current.left);
			PostOrder(current.right);
			System.out.print(current.data + " " );
		}
	}
	public void add(int key)
	{
		Node NewNode = new Node(key); // Make New Node
		Node current = root;
		if(current == null)
			root = NewNode;
		else
		{
			boolean exit = false;
			while(!exit)
			{
				if(key < current.data)
				{
					if(current.left == null)
					{
						// put here
						current.left = NewNode;
						exit = true;
					}
					else
						current = current.left;
				}
				else if(key > current.data)
				{
					if(current.right == null)
					{
						// put here
						current.right = NewNode;
						exit = true;
					}
					else
						current = current.right;
				}

			}
		}
	}
	// This method mainly calls deleteRec() 
	public void delete(int key) {
		root = deleteRec(root, key); 
	}

	/* A recursive function to insert a new key in BST */
	private Node deleteRec(Node root, int key) {

		/* Base Case: If the tree is empty */
		if(root == null) return root;

		/* Otherwise, recur down the tree */
		if(key  < root.data)
			root.left = deleteRec(root.left, key); 
		else if (key > root.data) 
			root.right = deleteRec(root.right, key); 

		// if key is same as root's key, then This is the node 
		// to be deleted 
		else {

			// node with no child 
			if( root.left == null && root.right == null) return null;

			// node with only one child
			if (root.left == null)  // No Left Child
				return root.right; 
			else if (root.right == null) // No Right Child
				return root.left;

			// nodes with two children

			// Find Minimum Value
			Node current = root.left;
			while(current.right != null ) current = current.right;
			int minValue = current.data; 

			// Set root data to minimum value
			root.data = minValue;

			// Delete the node
			root.left = deleteRec(root.left, minValue);
		}
		return root;
	}

	// ******************* Print Function ********************************** //
	// Function to print binary tree in 2D  
	public void printTree() {
		if( root != null) {
			printTree(root.right, true, "");
			System.out.println(root.data);
			printTree(root.left, false, "");

		}
	}
	// Function to print binary tree in 2D  
	private void printTree(Node node, boolean isRight, String indent) {
		if(node != null) {
			printTree(node.right, true, indent + (isRight ? "        " : " |      "));
			System.out.print(indent);
			if (isRight) System.out.print(" /");
			else System.out.print(" \\");
			System.out.print("----- ");
			System.out.println(node.data);
			printTree(node.left, false, indent + (isRight ? " |      " : "        "));
		}
	}
	// ******************* From Moodle ********************************** //
	// Ex10
	public void printInorder(){ InOrder(); }
	public void printPostorder (){ PostOrder(); }

	/* Computes the number of nodes in a tree. */
	public int size(){ 
		return size(root);
	}

	public int size(Node current) {
		if(current == null) return 0;
		else
			return size(current.left) + size(current.right) + 1;
	}

	// Ex11

	// Function to calculate number 
	// of children of given node 
	public int numOfChilds(int data){
		Node current = root;
		boolean exists = this.search(data);
		if(!exists) return Integer.MIN_VALUE;
		while(current.data != data) {
			if(current.data == data) break;
			else if(data > current.data) current = current.right;
			else 
				current = current.left;
		}
		return numOfChilds(current.left) + numOfChilds(current.right);
	}
	public int numOfChilds(Node current) {
		if(current == null) return 0;
		else
			return 1 + numOfChilds(current.right) + numOfChilds(current.left);
	}

    // Helper
	public String toString(){ 
		return "<" + toString(root) + ">";
	}
	
    // recursively printing out the nodes
	private String toString(Node n) {
		if(n == null) return "";
		else return n.data + "," + toString(n.right) + toString(n.left);
	}

	public int numOfLeaves(){ 
		return numOfLeaves(root);
	}
	private int numOfLeaves(Node curr) {
		if(curr == null) return 0;
		if(curr.left == null && curr.right == null) return 1;
		else return numOfLeaves(curr.left) + numOfLeaves(curr.right);
	}

	public int numOfParents (){ 
		return numOfParents(root);
		
	}
	private int numOfParents(Node curr) {
		if(curr == null) return 0;
		if(curr.left == null && curr.right == null) return 0;
		else return 1 + numOfParents(curr.left) + numOfParents(curr.right);
	}

	public BST_BeforeQuestions(BST_BeforeQuestions other){
		if(other == null) return;
		if(root == null && other != null) {
			root = new Node(other.root.data);
			DeepCopy(root,other.root);
		}
	}
	public void DeepCopy(Node ours, Node other) {
		ours.data = other.data;
		if(other.left != null) {
			ours.left = new Node(other.left.data);
			DeepCopy(ours.left,other.left);
		}
		if(other.right != null) {
			ours.right = new Node(other.right.data);
			DeepCopy(ours.right,other.right);
		}
	}
	// ******************* Question 1 ********************************** //
	public boolean isBST() { return true; }
	// ******************* Question 2 ********************************** //
	public static boolean isIdentical(Node x, Node y) { return true; }
	// ******************* Question 3 ********************************** //
	public static void convertToMirror(Node root) {}
	// ******************* Question 4 ********************************** //
	public Node findLCA(int n1, int n2) { return null; }
	// ******************* Question 5 ********************************** //
	public int kthSmallest(Node root, int k) { return Integer.MIN_VALUE; }
	// ******************* Question 6 ********************************** //
	public String isLeaf(int data){ return null; }
	// ******************* Question 7 ********************************** //
	// A:
	public void add (Node node, Node z) {}
	// B:
	public int less(Node node, int x) { return Integer.MIN_VALUE; }
	// ******************* Question 8 ********************************** //
	public static void printTreeByLevels(BST_BeforeQuestions tree) {}
	
	// ******************* Question 9 ********************************** //
	public boolean isFullTree(Node node) { return true; }
}