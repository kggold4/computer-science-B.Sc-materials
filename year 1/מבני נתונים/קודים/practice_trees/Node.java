package practice_trees;

// nodes of trees
public class Node {
    public Node left, right;
    public int data, bf;

    public Node(int data) {
        this.data = data;
        this.left = this.right = null;
        this.bf = 0;
    }

    public String toString() {
        return "" + this.data;
    }
}