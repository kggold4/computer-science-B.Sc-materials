package lecture6;

public class BinaryTree {

    BTNode root;
    int size;

    // constructor
    public BinaryTree() {
        this.root = null;
        this.size = 0;
    }

    public void add(Object data) {
        root = add(data, root);
    }

    private BTNode add(Object data, BTNode node) {
        if(node != null) {
            double rand = Math.random();
            if(rand < 0.5) {
                node.left = add(data, node.left);
                return node.left;
            } else {
                node.right = add(data, node.right);
                return node.right;
            }
        }
        node = new BTNode(data);
        return node;
    }

    public void insert(Object data) {
        boolean flag = false;
        BTNode node = root;
        if(root == null) {
            root = new BTNode(data);
            flag = true;
        }
        while(!flag) {
            double rand = Math.random();
            if(rand < 0.5) {
                if(node.left == null) {
                    node.left = new BTNode(data);
                    flag = true;
                }
                node = node.left;
            } else {
                if(node.right == null) {
                    node.right = new BTNode(data);
                    flag = true;
                }
                node = node.right;
            }
        }
    }

    // preorder (parent -> left -> right)
    public void preorderTraverse(BTNode node) {
        if(node != null) {
            System.out.print(" -> " + node);
            preorderTraverse(node.left);
            preorderTraverse(node.right);
        }
    }

    // inorder (left -> parent -> rigth)
    public void inorderTravese(BTNode node) {
        if(node != null) {
            inorderTravese(node.left);
            System.out.println(node);
            inorderTravese(node.right);
        }
    }

    // postorder (left -> right -> parent)
    public void postorderTravese(BTNode node) {
        if(node != null) {
            postorderTravese(node.left);
            postorderTravese(node.right);
            System.out.println(node);
        }
    }

    public boolean contains(BTNode node ,Object data) {
        
        boolean isContains = false;
        if(node != null) {
            isContains = (data == node.data) || contains(node.left, data) || contains(node.right, data);
        }
        return isContains;

    }

    public int height(BTNode node) {
        int h = 0;
        if(node != null) {
            int leftH = height(node.left);
            int rightH = height(node.right);
            if(leftH > rightH) h = leftH + 1;
            else h = rightH + 1;
        }

        return h;
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.insert(5);
        tree.insert(6);
        tree.insert(3);
        tree.insert(2);
        tree.preorderTraverse(tree.root);
    }
}