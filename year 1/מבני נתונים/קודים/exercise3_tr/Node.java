package exercise3_tr;

public class Node {
	int data;
	Node left, right;
	public int num;
	
	public Node(int data) {
		this.data = data;
		this.left = this.right = null;
		num = 1;
	}
}