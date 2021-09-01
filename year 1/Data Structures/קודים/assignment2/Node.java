package assignment2;

public class Node {
    public Node left, right;
    public Integer data;

    public Node(Integer data) {
        this.data = data;
        this.left = this.right = null;
    }

    public Integer getData() {
        return  this.data;
    }

    public Node getLeft() {
        return  this.left;
    }

    public Node getRight() {
        return this.right;
    }

    public String toString() {
        return "" + this.data;
    }
}