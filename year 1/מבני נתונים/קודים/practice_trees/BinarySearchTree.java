package practice_trees;

import java.util.NoSuchElementException;

public class BinarySearchTree {

    // root
    private Node root;
    public Node getRoot() { return this.root; }

    // constructor
    public BinarySearchTree() { this.root = null; }

    // is empty method
    public boolean isEmpty() { return this.root == null; }

    // size
    public int size() { return size(this.root); }
    private int size(Node node) { return (node == null) ? 0 : size(node.left) + size(node.right) + 1; }

    // height
    public int height() { return height(this.root); }
    private int height(Node node) {
        if(node == null) return -1;
        else return Integer.max(height(node.left), height(node.right)) + 1;
    }

    // contains method
    public boolean contains(int data) {
        if(this.isEmpty()) return false;
        else return contains(this.root, data);
    }
    private boolean contains(Node node, int data) {
        if(node == null) return false;
        if(node.data == data) return true;
        if(node.data < data) return contains(node.right, data);
        else return contains(node.left, data);
    }

    public Node max() { return max(this.root); }
    private Node max(Node node) {
        if(node.right == null) return node;
        else return max(node.right);
    }

    public Node min() { return min(this.root); }
    private Node min(Node node) {
        if(node.left == null) return node;
        else return min(node.left);
    }

    // adding method
    public void add(int data) { this.root = add(this.root, data); }
    private Node add(Node node, int data) {
        if(node == null) return new Node(data);
        else if(data < node.data) node.left = add(node.left, data);
        else node.right = add(node.right, data);
        return node;
    }

    // delete method
    public void delete(int data) {
        if(!this.contains(data)) throw new NoSuchElementException("data cannot be found in the tree");
        else this.root = delete(this.root, data);
    }
    private Node delete(Node node, int data) {
        if(data < node.data) node.left = delete(node.left, data);
        else if(data > node.data) node.right = delete(node.right, data);

        // found the node
        else {

            // leave
            if(node.left == null && node.right == null) return null;

            // have one child
            if(node.left == null) return node.left;
            else if(node.right == null) return node.right;

            // have two child
            else {
                int minValue = min(node.right).data;
                node.data = minValue;
                node.right = delete(node.right, minValue);
            }
        }
        return node;
    }
}
