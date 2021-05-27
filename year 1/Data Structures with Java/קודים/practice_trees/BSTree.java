package practice_trees;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.NoSuchElementException;

// binary search tree
public class BSTree {

    private Node root;

    // constructor
    public BSTree() {
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

            // one children
            if(node.right == null) return node.left;
            else if(node.left == null) return node.right;

            // two children
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
    public int height(Node node) {
        if(node == null) return -1;
        else return Integer.max(height(node.left), height(node.right)) + 1;
    }

    // getting tree size method
    public int size() { return size(this.root); }
    private int size(Node node) { return (node == null) ? 0 : size(node.left) + size(node.right) + 1; }

    // isEmpty method
    public boolean isEmpty() { return this.root == null; }

    // toString method
    public String toString() { return toString(this.root); }
    private String toString(Node node) {
        if(node == null) return "";
        else return node.data + toString(node.left) + toString(node.right);
    }

    // number of Children method
    public int numOfChildren(int data) {
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

    // number of leaves method
    public int numOfLeaves() { return this.isEmpty() ? 0 : numOfLeaves(this.root); }
    private int numOfLeaves(Node node) {
        if(node == null) return 0;
        if(node.left == null && node.left == null) return 1;
        else return (numOfLeaves(node.left) + numOfLeaves(node.right));
    }

    // number of parents method
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

    public boolean isBalanced() { return isBalanced(this.root); }
    private boolean isBalanced(Node node) {
        if(node == null) return true;
        else return (Math.abs(height(node.right) - height(node.left)) <= 1 );
    }

    // statics functions

    // checking if two trees are equals function
    public static boolean equals(BSTree tree1, BSTree tree2) {
        return equals(tree1.root, tree2.root);
    }

    private static boolean equals(Node node1, Node node2) {
        if(node1 == null & node2 == null) return true;
        if(node1 != null && node2 != null) return (node1.data == node2.data && equals(node1.left, node2.left) && equals(node1.right, node2.right));
        return false;
    }

    // convertToMirror function
    public static void convertToMirror(BSTree tree) { convertToMirror(tree.root); }
    private static void convertToMirror(Node node) {
        if(node == null) return;
        convertToMirror(node.left);
        convertToMirror(node.right);
        swap(node);
    }

    public static Integer maxSum(BSTree tree) {
        // if tree is empty return sum 0
        if(tree.root == null) return 0;

        // number of leaves is equal to number of sums,
        // make an array for all path sum
        int[] emptySums = new int[tree.numOfLeaves()];

        // getting the sums recursively in to the array
        int[] sums = maxSum(tree.root, emptySums, 0, 0);

        // getting and return the max sum path from the array
        int max = sums[0];
        for(int i = 1; i < sums.length; i++) { // O(number of paths)
            if(max < sums[i]) max = sums[i];
        }
        return max;
    }

    // in bad case the complexity is O(n^2) because the function going throw all paths of the array
    // and can go throw the same nodes a couple of time
    private static int[] maxSum(Node node, int[] sums, int i, int sum) {
        // return sums array when get to nil
        if(node == null) return sums;

        // getting sum of all node data in the path
        sum = sum + node.data;

        // if get to leave insert sum of path to the array
        if(node.left == null && node.right == null) {
            sums[i] = sum;
            sum = 0;
            i++;
        } else {
            // recursively calculating the sums of all paths
            maxSum(node.left, sums, i, sum);
            maxSum(node.right, sums, i, sum);
        }

        // return path
        return sums;
    }

    // swapping left and right nodes
    public static void swap(Node node) {
        if(node == null) return;
        Node temp = node.left;
        node.left = node.right;
        node.right = temp;
    }

    public static void main(String[] args) {
        BSTree tree = new BSTree();

        for(int i = 0; i < 10000; i++) {
            tree.add((int)(Math.round(Math.random() * 100)));
        }

        PrintTrees.inOrder(tree);
        System.out.println("max sum: " + maxSum(tree));
    }
}