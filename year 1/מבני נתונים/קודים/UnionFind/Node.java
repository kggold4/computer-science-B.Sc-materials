package UnionFind;

public class Node {
    public Node left, right, parent;
    public Integer data;
    public int size, rank;
    public Node(int data) {
        this.data = data;
        this.left = this.right = this.parent = null;
        this.size = this.rank = 0;
    }
    public Node find(Node v) {
        if(v == v.parent) return v;
        return find(v.parent);
    }
    public void makeSet(Node v) {
        v = v.parent;
        this.size = 1;
        this.rank = 0;
    }
}
