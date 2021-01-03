package practice_trees;

// balanced binary search tree (AVL tree)
public class BBSTree extends BSTree {

    private Node root;

    // constructor
    public BBSTree() { this.root = null; }

    // add
    public void add(int data) {
        if(!this.contains(data)) this.root = add(data, this.root);
        else throw new RuntimeException("data already exist");
    }

    private Node add(int data, Node node) {
        if(node == null) return new Node(data);

        if(data < node.data) node.left = add(data, node.left);
        else node.right = add(data, node.right);

        // update the balance factor
        update(node);

        // return balanced tree
        return balance(node);
    }

    // update the balance factor method
    private void update(Node node) {
        int rightHeight = height(node.right);
        int leftHeight = height(node.left);
        node.bf = rightHeight - leftHeight;
    }

    // https://www.youtube.com/watch?v=e1XGscJOfcE&list=PLskc-ZNWyaRoPa2QLYmrF2ffYmVLPdOS2&index=10&t=0s
    // balance factor method
    private Node balance(Node node) {
        // R
        if(node.bf == 2) {
            if(node.right.bf <= 0) return rightLeftCase(node);
            else return rightRightCase(node);
        // L
        } else if(node.bf == -2) {
            if(node.left.bf <= 0) return leftLeftCase(node);
            else return leftRightCase(node);
        } else return node;
    }

    // RR Case
    private Node rightRightCase(Node node) {
        return rightRotation(node);
    }

    // RL Case
    private Node rightLeftCase(Node node) {
        node.right = rightRotation(node.right);
        return leftRotation(node);
    }

    // LL Case
    private Node leftLeftCase(Node node) {
        return leftRotation(node);
    }

    // LR Case
    private Node leftRightCase(Node node) {
        node.left = leftRotation(node.left);
        return rightRotation(node);
    }

    // left rotation
    private Node leftRotation(Node z) {
        Node y = z.right;
        z.right = y.left;
        y.left = z;
        update(z);
        update(y);
        return y;
    }

    // right rotation
    private Node rightRotation(Node z) {
        Node y = z.left;
        z.left = y.right;
        y.right = z;
        update(z);
        update(y);
        return y;
    }

    public static void main(String[] args) {
        BBSTree tree = new BBSTree();

        tree.add(6);

//        System.out.println("height is: " + tree.height());
        tree.add(2);
        tree.add(7);
//        System.out.println("height is: " + tree.height());
        tree.add(3);
        tree.add(9);
//        System.out.println("height is: " + tree.height());
        tree.add(10);
//        System.out.println("root is: " + tree.getRoot());
//
        PrintTrees.inOrder(tree);
    }
}