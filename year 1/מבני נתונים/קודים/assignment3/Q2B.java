package assignment3;

import java.util.Arrays;
import java.util.LinkedList;

public class Q2B {

    /**
     * function that return string of nodes of the max sum path from leave to root in the tree,
     * the function use the getLeave function to get all tree leaves in the tree,
     * and than use the getPath function to get a path from leave to root,
     * and than use the getSum function to get a sum of a path
     * and than with an index value, calculate who had the max sum in tree paths
     * create a string looking like: "1 -> 2 -> 3 -> 4 -> 5  -> null",
     * and return the string
     * all the complexity of the the other function are detailed below
     * @param tree - the tree that the function work on
     * @return maxPathSumOutput - the string of the max sum path in the tree
     */
    public static String maxSumPath(BinaryTree tree) {

        // getting tree leaves
        LinkedList<Node> leaves = getLeaves(tree);

        // calculate the max sum path
        int max = 0, maxIndex = 0;
        for(int i = 0; i < leaves.size(); i++) {
            if(max < getSum(getPath(leaves.get(i), tree))) {
                max = getSum(getPath(leaves.get(i), tree));
                maxIndex = i;
            }
        }

        // create a string maxPathSumOutput of the max sum path from root to leave
        LinkedList<Integer> maxPathSum = getPath(leaves.get(maxIndex), tree);
        String maxPathSumOutput = "";
        for(int i = maxPathSum.size() - 1; i >= 0 ; i--) {
            maxPathSumOutput += maxPathSum.get(i) + " -> ";
        }
        maxPathSumOutput += "null";

        // return the string
        return maxPathSumOutput;
    }

    /**
     * function that return the sum of a linked list of integers to get paths sum
     * going throw all the nodes in the path from leave to the root
     * so the max complexity is O(height(tree))
     * @param path - a linked list of path nodes data
     * @return sum - the sum of the nodes data in the path
     */
    private static int getSum(LinkedList<Integer> path) {
        int sum = 0;
        for(int i = 0; i < path.size(); i++) sum += path.get(i);
        return sum;
    }

    /**
     * function that return linked list of nodes with the leaves of a tree
     * in every search for a leave the function go throw all the nodes in the path to get to the leave
     * some searches probably will go throw a nodes that visited already
     * in every search for leave the worst case is that the function can throw all node int the tree
     * so the complexity is O(n) in every search for leave
     * @param tree - searching tree leaves
     * @return leaves - linked list of tree leaves
     */
    // function that return
    public static LinkedList<Node> getLeaves(BinaryTree tree) {
        LinkedList<Node> paths = new LinkedList<Node>();
        return getLeaves(tree.root, paths);
    }

    /**
     * recursively function for getLeaves function
     * @param node - starting from the root of the tree and get recursively down to leaves
     * @param leaves - the leaves list that will return
     * @return leaves
     */
    // get leaves recursively
    private static LinkedList<Node> getLeaves(Node node, LinkedList<Node> leaves) {
        if(node == null) return leaves;
        // if found a leave add to list
        if(node.left == null && node.right == null) leaves.add(node);
        // going throw all left and right nodes
        else {
            getLeaves(node.left, leaves);
            getLeaves(node.right, leaves);
        }
        // return the tree leaves list
        return leaves;
    }

    /**
     * function that can get the path form leave to root in the tree
     * the function go from leave node to the root node
     * so the complexity of the the function in every call is O(height(tree))
     * @param node - the leave that the function work on to get it's path to root
     * @param tree - the tree
     * @return path - linked list with node path to the root
     */
    public static LinkedList<Integer> getPath(Node node, BinaryTree tree) {
        LinkedList<Integer> path = new LinkedList<Integer>();
        while(node != tree.root) {
            // adding to path list all node in the path from leave to root
            path.add(node.data);
            node = node.parent;
        }
        // adding the root
        path.add(tree.root.data);
        return path;
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.add(7);
        tree.add(1);
        tree.add(6);
        tree.add(9);
        tree.add(8);
        tree.add(11);
        tree.add(10);
        tree.add(4);
        tree.add(5);

        System.out.println(maxSumPath(tree));
    }
}