package exercise3_self;

public class Node {
    public Node left, right;
    public Integer data;

    public Node(Integer data) {
        this.data = data;
        this.left = this.right = null;
    }
}