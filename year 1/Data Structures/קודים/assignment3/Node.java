package assignment3;

// nodes of trees
public class Node {
    public Node left, right, parent;
    public Integer data, bf;

    public Node(Integer data) {
        this.data = data;
        this.left = this.right = this.parent = null;
        this.bf = 0;
    }

    public String toString() {
        return "" + this.data;
    }
}