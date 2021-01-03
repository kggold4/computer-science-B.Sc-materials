package assignment2;

import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Queue;

public class BinaryTree {
    public Node root;

    public BinaryTree() {
        this.root = null;
    }

    // return root method
    public Node getRoot() { return this.root; }

    // getting max method
    public int max() {
        if(this.isEmpty()) {
            System.out.print("tree is empty: ");
            return -1;
        } else return max(this.root);
    }

    private int max(Node node) {
        if(node.right != null) return max(node.right);
        else return node.data;
    }

    // getting min method
    public int min() {
        if(this.isEmpty()) {
            System.out.print("tree is empty: ");
            return -1;
        } else return min(this.root);
    }

    private int min(Node node) {
        if(node.left != null) return max(node.left);
        else return node.data;
    }

    // print tree in preorder
    public void preOrder() { preOrder(this.root); } // parent -> left -> right
    private void preOrder(Node node) {
        if(node != null) {
            System.out.print(node + " ");
            preOrder(node.left);
            preOrder(node.right);
        }
    }

    // print tree in inorder
    public void inOrder() { inOrder(this.root); } // left -> parent -> right
    private void inOrder(Node node) {
        if(node != null) {
            inOrder(node.left);
            System.out.print(node + " ");
            inOrder(node.right);
        }
    }

    // print tree in postorder
    public void postOrder() { postOrder(this.root); } // left -> right -> parent
    private void postOrder(Node node) {
        if(node != null) {
            postOrder(node.left);
            postOrder(node.right);
            System.out.print(node + " ");
        }
    }

    // contains method
    public boolean contains(int data) { return this.isEmpty() ? false : contains(data, this.root); }
    private boolean contains(int data, Node node) {
        if(node == null) return false;
        if(node.data == data) return true;
        else if(data < node.data) return contains(data, node.left);
        else return contains(data, node.right);
    }

    // add method
    public void add(int data) { this.root = add(data, this.root); }
    private Node add(int data, Node node) {
        if(node == null) return new Node(data);
        else if(data < node.data) node.left = add(data, node.left);
        else node.right = add(data, node.right);
        return node;
    }

    // delete method
    public void delete(int data) {
        if(this.isEmpty()) System.out.println(data + " is not found on the tree");
        else this.root = delete(data, this.root);
    }

    private Node delete(int data, Node node) {
        if(data < node.data) node.left = delete(data, node.left);
        else if(data > node.data) node.right = delete(data, node.right);

            /// found
        else {

            // leaf
            if(node.left == null && node.right == null) return null;

            // childs
            if(node.right == null) return node.left;
            else if(node.left == null) return node.right;

                // two childs
            else {
                int minValue = min(node.right);
                node.data = minValue;
                node.right = delete(minValue, node.right);
            }
        }
        return node;
    }

    // getting tree height method
    public int height() { return height(this.root); }
    private int height(Node node) {
        if(node == null) return -1;
        else return Integer.max(height(node.left), height(node.right));
    }

    // getting tree size method
    public int size() { return size(this.root); }
    private int size(Node node) {
        return node == null ? 0 : size(node.left) + size(node.right) + 1;
    }

    // isEmpty method
    public boolean isEmpty() { return this.root == null; }

    // toStrng method
    public String toString() { return toString(this.root); }
    private String toString(Node node) {
        if(node == null) return "";
        else return node.data + toString(node.left) + toString(node.right);
    }

    // numer of childs method
    public int numOfChilds(int data) {
        Node node = this.root;
        boolean found = this.contains(data);
        if(!found) throw new NoSuchElementException("data cannot be found in the tree");
        else {

            // search
            while(data != node.data) {
                if(data == node.data) break;
                else if(data < node.data) node = node.left;
                else node = node.right;
            }
            return size(node.left) + size(node.right);
        }
    }

    // numer of leavs method
    public int numOfLeavs() { return this.isEmpty() ? 0 : numOfLeavs(this.root); }
    private int numOfLeavs(Node node) {
        if(node == null) return 0;
        if(node.left == null && node.left == null) return 1;
        else return (numOfLeavs(node.left) + numOfLeavs(node.right));
    }

    // numer of parents method
    public int numOfParents() { return numOfParents(this.root); }
    private int numOfParents(Node node) {
        if(node == null) return 0;
        if(node.left == null && node.left == null) return 0;
        else return (numOfParents(node.left) + numOfParents(node.right) + 1);
    }

    // getting the lowest common ancestor (LCA) of two node method
    public int lca(int n1, int n2) {
        LinkedList<Node> path1 = this.findPath(n1);
        LinkedList<Node> path2 = this.findPath(n2);

        int i = 0;
        for(; i < path1.size() && i < path2.size(); i++) if(path1.get(i) != path2.get(i)) break;
        return path1.get(i - 1).data;
    }

    // getting the path do data
    private LinkedList<Node> findPath(int data) {
        LinkedList<Node> path = new LinkedList<>();
        return findPath(data, path, this.root);
    }

    private LinkedList<Node> findPath(int data, LinkedList<Node> path, Node node) {
        if(node == null) return path;
        path.add(node);
        if(data > node.data) findPath(data, path, node.right);
        else findPath(data, path, node.left);
        return path;
    }

    // statics functions

    // checking if two trees are equals function
    public static boolean equals(BinaryTree tree1, BinaryTree tree2) {
        return equals(tree1.root, tree2.root);
    }

    private static boolean equals(Node node1, Node node2) {
        if(node1 == null & node2 == null) return true;
        if(node1 != null && node2 != null) return (node1.data == node2.data && equals(node1.left, node2.left) && equals(node1.right, node2.right));
        return false;
    }

    // convertToMirror funciton
    public static void convertToMirror(BinaryTree tree) { convertToMirror(tree.root); }
    public static void convertToMirror(Node node) {
        if(node == null) return;
        convertToMirror(node.left);
        convertToMirror(node.right);
        swap(node);
    }

    // swaping left and right nodes
    public static void swap(Node node) {
        if(node == null) return;
        Node temp = node.left;
        node.left = node.right;
        node.right = temp;
    }

    public static void printTreeByLevels(BinaryTree tree) {
        if(tree.isEmpty()) return;

        Queue<Node> queue = new LinkedList<>();
        queue.add(tree.getRoot());

        while(!queue.isEmpty()) {
            int nodesInLevel = queue.size();
            while(nodesInLevel > 0) {
                Node top = queue.poll();
                System.out.println(top.data + " ");
                if(top.left != null) queue.add(top.left);
                if(top.right != null) queue.add(top.right);
                nodesInLevel--;
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.add(1);
        tree.add(5);
        tree.add(8);
        tree.add(3);
        tree.add(7);
        tree.inOrder();
        convertToMirror(tree);
        System.out.println();
        tree.inOrder();
    }
}
