package practice_union;

public class UnionFind {
    UFNode[] nodes;

    public UnionFind(int max) {
        nodes = new UFNode[max];
    }

    // make set containing only given element (a singleton)
    public void makeSet(int k) {
        nodes[k] = new UFNode(k, 0);
    }

    public int find(int v) {
        int p = this.nodes[v].parent;
        if(v == p) return v;
        return find(p);
    }

    // join two subsets into a single subset
    public void union(int a, int b) {
        int aRoot = find(a);
        int bRoot = find(b);
        if(aRoot == bRoot) return;;
        if(this.nodes[aRoot].rank > this.nodes[bRoot].rank) {
            this.nodes[bRoot].parent = aRoot;
        } else if(this.nodes[aRoot].rank < this.nodes[bRoot].rank) {
            this.nodes[aRoot].parent = bRoot;
        } else { // aRoot.rank == bRoot.rank
            this.nodes[bRoot].parent = aRoot;
            this.nodes[aRoot].rank++;
        }
    }
}