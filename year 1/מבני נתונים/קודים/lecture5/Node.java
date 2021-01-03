package lecture5;

public class Node {
    public Integer data;
    public Node next;

    //constructor
    public Node(Integer data, Node next) {
        this.data = data;
        this.next = next;
    }

    public String toString() {
        return "" + this.data;
    }
}