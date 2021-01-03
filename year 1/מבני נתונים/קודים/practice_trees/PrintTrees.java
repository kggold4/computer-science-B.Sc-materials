package practice_trees;

import java.util.LinkedList;
import java.util.Queue;

// class with print services for trees
public class PrintTrees {
    // print tree in preorder
    // parent -> left -> right
    public static void preOrder(BSTree tree) {
        preOrder(tree.getRoot());
    }

    private static void preOrder(Node node) {
        if (node != null) {
            System.out.print(node + " ");
            preOrder(node.left);
            preOrder(node.right);
        }
    }

    // print tree in inorder
    // left -> parent -> right
    public static void inOrder(BSTree tree) {
        inOrder(tree.getRoot());
    }

    private static void inOrder(Node node) {
        if (node != null) {
            inOrder(node.left);
            System.out.print(node + " ");
            inOrder(node.right);
        }
    }

    // print tree in postorder
    // left -> right -> parent
    public static void postOrder(BSTree tree) {
        postOrder(tree.getRoot());
    }

    private static void postOrder(Node node) {
        if (node != null) {
            postOrder(node.left);
            postOrder(node.right);
            System.out.print(node + " ");
        }
    }

    // print tree nodes by level
    public static void printTreeByLevels(BSTree tree) {
        if (tree.isEmpty()) return;

        Queue<Node> queue = new LinkedList<>();
        queue.add(tree.getRoot());

        while (!queue.isEmpty()) {
            int nodesInLevel = queue.size();
            while (nodesInLevel > 0) {
                Node top = queue.poll();
                System.out.println(top.data + " ");
                if (top.left != null) queue.add(top.left);
                if (top.right != null) queue.add(top.right);
                nodesInLevel--;
            }
            System.out.println();
        }
    }
}