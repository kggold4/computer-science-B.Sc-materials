package UnionFind;

public class Rank {
    public void union(Node a, Node b) {
        Node aRoot = a.find(a);
        Node bRoot = b.find(b);

        if(aRoot != bRoot) {
            if(aRoot.rank < bRoot.rank) {
                aRoot.parent = bRoot;
            } else if(aRoot.rank > bRoot.rank) {
                bRoot.parent = aRoot;
            } else {
                bRoot.parent = aRoot;
                aRoot.rank = aRoot.rank + 1;
            }
        }
    }
}