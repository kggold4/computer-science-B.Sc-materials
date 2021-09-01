package practice_binomial;

public class Node {
    Node parent, sibling, child;
    int degree, data;

    public Node(int data) {
        this.data = data;
        this.degree = 0;
    }
}