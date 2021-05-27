package lecture6;

public class BTNode {
    Object data;
    BTNode left, right;

    // constructors
    public BTNode(Object data,BTNode left, BTNode right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }

    public BTNode(Object data) {
        this.data = data;
        this.left = this.right = null;
    }

    public String toString() {
        return "" + this.data;
    }
}