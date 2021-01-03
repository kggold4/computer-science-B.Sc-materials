package assignment2;

import java.util.NoSuchElementException;
import java.util.Stack;

public class Q2 {

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.add(15);
        tree.add(10);
        tree.add(7);
        tree.add(3);
        tree.add(9);
        boolean isBinaryTree = isBST(tree);
        System.out.println(isBinaryTree);
    }
    
    public static boolean isBST(BinaryTree bt) {

        // if tree is empty
        if(bt.root == null) throw new NoSuchElementException("tree is empty");

        // if tree is not empty
        else {

            // getting a stack with tree values by inOrder order
            Stack<Integer> insertTreeValues = new Stack<>();
            Stack<Integer> treeValues = inOrderForIsBST(bt.root, insertTreeValues);

            // checking if the pop value is grater than the peek value
            // checking if the tree is not a binary search tree - O(n)
            while(treeValues.size() > 1) {
                Integer temp = treeValues.pop();
                if(temp <= treeValues.peek()) return false;
            }
        }

        // return true if the tree is a binary search tree
        return true;
    }

    // auxiliary function that helping me to to insert tree values to stack by inOrder order recurly
    public static Stack<Integer> inOrderForIsBST(Node node, Stack<Integer> insertTreeValues) {
        if(node != null) {
            inOrderForIsBST(node.left, insertTreeValues);
            insertTreeValues.push(node.data);
            inOrderForIsBST(node.right, insertTreeValues);
        }

        // return the stack with tree values
        return insertTreeValues;
    }
}