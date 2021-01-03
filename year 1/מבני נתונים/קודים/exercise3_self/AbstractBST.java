package exercise3_self;

import java.util.NoSuchElementException;
import java.util.Stack;

public class AbstractBST {

    public Node root;

    // main constructor
    public AbstractBST() {
        this.root = null;
    }

    // copy constructor
    public AbstractBST(AbstractBST other) {
        if(other == null) return;
        this.root = new Node(other.root.data);
        DeepCopy(this.root, other.root);
    }

    public void DeepCopy(Node that, Node other) {
        that.data = other.data;
        if(that.left != null) {
            if(other.left != null) that.left = new Node(other.left.data);
            DeepCopy(that.left, other.left);
        }
        if(other.right != null) {
            if(other.right != null) that.right = new Node(other.right.data);
            DeepCopy(that.right, other.right);
        }

    }

    // min method
    public int min() {
        if(this.isEmpty()) throw new NoSuchElementException("tree is empty");
        return min(root);
    }

    private int min(Node node) { return (node.left == null) ? node.data : min(node.left); }

    //max method
    public int max() {
        if(this.isEmpty()) throw new NoSuchElementException("tree is empty");
        return max(root);
    }

    private int max(Node node) { return (node.right == null) ? node.data : max(node.right); }

    // contains method
    public boolean contains(Integer data) {
        return contains(data, root);
    }

    private boolean contains(Integer data, Node node) {
        if(node.data == null) return false;
        if(node.data == data) return true;
        else if(node.data < data) return contains(data, node.right);
        else return contains(data, node.left);
    }

    // tree height
    public int height() { return height(root); }
    private int height(Node node) {
        if(node == null) return -1;
        return Integer.max(height(node.left), height(node.right) + 1);
    }

    public void preOrder() { preOrder(root); } // parent -> left -> right
    private void preOrder(Node node) {
        if(node != null) {
            System.out.println(node.data + " ");
            preOrder(node.left);
            preOrder(node.right);
        }
    }

    public void inOrder() { inOrder(root); } // left -> parent -> right
    private void inOrder(Node node) {
        if(node != null) {
            inOrder(node.left);
            System.out.println(node.data + " ");
            inOrder(node.right);
        }
    }

    public void postOrder() { postOrder(root); } // left -> right -> parent
    private void postOrder(Node node) {
        if(node != null) {
            postOrder(node.left);
            postOrder(node.right);
            System.out.println(node.data + " ");
        }
    }
    
    // adding integer to tree
    public void add(Integer data) { this.root = add(data, this.root); }

    private Node add(Integer data, Node node) {
        if(node == null) return new Node(data);
        else {
            if(data < node.data) node.left = add(data, node.left);
            else if(data > node.data) node.right = add(data, node.right);
            else throw new RuntimeException("cannot add data that already in the tree");
        }
        return node;
    }

    // delete item from tree
    public void delete(Integer data) { this.root = delete(data, root); }

    private Node delete(Integer data, Node node) {
        if(!contains(data)) return null;

        if(data < node.data) node.left = delete(data, node.left);
        else if(data > node.data) node.right = delete(data, node.right);

        //found data to delete
        else {

            // leaf
            if(node.left == null && node.right == null) return null;

            // one children
            if(node.left == null) return node.right;
            else if(node.right == null) return node.left;

            // two childrens
            int minValue = min(node.right);
            node.data = minValue;
            node.right = delete(minValue, node.right);

        }
        return node;
    }

    // size method
    public int size() { return size(root); }
    private int size(Node node) {
        return node == null ? 0 : (size(node.left) + size(node.right) + 1);
    }
    

    public boolean isEmpty() {
        return (root == null) ? false : true;
    }

    public int numOfChildrens() {
        return numOfChildrens(root.data);
    }

    public int numOfChildrens(int data) {
        Node node = root;
        boolean found = this.contains(data, root);
        if(!found) throw new NoSuchElementException("data cannot be found in the tree");
        else {
            while(node.data != data) {
                if(node.data == data) break;
                else if(data > node.data) node = node.right;
                else node = node.left;
            }
        }
        return size(node.left) + size(node.right);
    }

    // to string method
    public String toString() { return toString(root); }

    private String toString(Node node) {
        if(node == null) return "";
        else {
            return node.data + toString(node.left) + toString(node.right);
        }
    }

    public int numOfLeavs(Node node) {
        if(node == null) return 0;
        else if(node.left == null && node.right == null) return 1;
        else return numOfLeavs(node.left) + numOfLeavs(node.right);
    }

    public int numOfParents(Node node) {
        if((node == null) || (node.left == null && node.right == null)) return 0;
        else return numOfParents(node.left) + numOfParents(node.right) + 1;
    }

    public static boolean isBST(AbstractBST bt) {
        if(bt.root == null) {
            System.out.print("tree is empty : ");
            return false;
        } else {
            Stack<Integer> insertTreeValues = new Stack<>();
            Stack<Integer> treeValues = inOrderForIsBST(bt.root, insertTreeValues);
            System.out.println("treeValues: " + treeValues);
            while(treeValues.size() > 1) {
                Integer temp = treeValues.pop();
                if(temp <= treeValues.peek()) return false;
            }
        }
        return true;
    }

    public static Stack<Integer> inOrderForIsBST(Node node, Stack<Integer> insertTreeValues) {

        if(node != null) {
            inOrderForIsBST(node.left, insertTreeValues);
            insertTreeValues.push(node.data);
            inOrderForIsBST(node.right, insertTreeValues);
        }
        return insertTreeValues;
    }

    public static void main(String[] args) {
        AbstractBST tree = new AbstractBST();
        tree.add(7);
        tree.add(5);
        tree.add(6);
        tree.add(1);
        tree.add(8);
    }

}