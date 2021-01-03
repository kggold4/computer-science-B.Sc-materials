package lecture5;

public class NodeCycle {
    public Integer data;
    public NodeCycle next;

    //constructor
    public NodeCycle(Integer data, NodeCycle next) {
        this.data = data;
        this.next = next;
    }

    public String toString() {
        return "" + this.data;
    }
}
