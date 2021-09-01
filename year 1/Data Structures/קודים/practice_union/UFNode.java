package practice_union;

public class UFNode {
    int parent;
    int rank;

    public UFNode(int parent, int rank) {
        this.parent = parent;
        this.rank = rank;
    }
    public String toString() {
        return "[p: " + parent + ", r: " + rank + "]";
    }
}