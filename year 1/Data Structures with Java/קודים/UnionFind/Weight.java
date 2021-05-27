package UnionFind;

public class Weight {
    public void makeSet(Node v) {
        v = v.parent;
        v.size = 1;
    }

    // O(log2n)
    public void union(Node a, Node b) {
        Node aRoot = a.find(a);
        Node bRoot = b.find(b);

        if(aRoot != bRoot) {
            if(aRoot.size < bRoot.size) {
                aRoot.parent = bRoot;
                bRoot.size = bRoot.size + aRoot.size;
            } else {
                bRoot.parent = aRoot;
                aRoot.size = aRoot.size + bRoot.size;
            }
        }
    }
}