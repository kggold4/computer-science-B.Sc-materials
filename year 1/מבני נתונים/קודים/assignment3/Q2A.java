package assignment3;

import java.util.Arrays;

public class Q2A {

    /**
     * function that return the max sum of a path from the root to leave,
     * in bad case the complexity of every time the function work recursively is O(height(tree)),
     * because the function going throw all paths of the array in every call,
     * @param tree - the tree that the function work on,
     * @return max - the max sum of a path from root to leave.
     */
    public static Integer maxSum(BinaryTree tree) {
        // if tree is empty return sum 0
        if(tree.root == null) return 0;

        // number of leaves is equal to number of sums,
        // that why i used numOfLeaves() function to calculate number of leaves = number of paths
        // make an array for all path sum
        int[] emptySums = new int[tree.numOfLeaves()];

        // getting the sums recursively in to the array
        int[] sums = maxSum(tree.root, emptySums, 0, 0);

        // getting and return the max sum path from the array
        int max = sums[0];
        for(int i = 1; i < sums.length; i++) { // O(number of paths)
            if(max < sums[i]) max = sums[i];
        }

        // return max
        return max;
    }

    /**
     * the recursive function of maxSum function that work recursively on tree paths,
     * and calculate all sums of the paths of the tree and insert the sums to sums array and return the array,
     * @param node - recursively the node that we get his data and add it to the sum of it's path,
     *             - changing by node.left and node.right from the tree root until get null node,
     * @param sums - the array of the sums of the tree paths, recursively adding sum after going throw path,
     * @param i    - the index of sums array,
     * @param sum  - the sum of the path,
     * @return sums - the array with all sums of paths in the tree.
     */
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

        // return paths sum
        return sums;
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

        System.out.println(maxSum(tree));
    }
}
