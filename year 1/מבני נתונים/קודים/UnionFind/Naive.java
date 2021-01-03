package UnionFind;

public class Naive {

    // O(n)
    public void union(Node a, Node b) {
        a = a.find(a);
        b = b.find(b);
        if(a != b) b.parent = a;
    }
}
