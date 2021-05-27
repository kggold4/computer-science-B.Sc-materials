package lecture7;

public class Node {
    public Integer data;
    public Node left, right;

    // constructor

    public Node(Integer data) {
        this.data = data;
        this.left = this.right = null;
    }

    public Node(Integer data, Node left, Node right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }

    public String toString() {
        return "" + this.data;
    }
}