package lecture7;

public class SearchBinaryTree {
    Node root;
    int size;

    public SearchBinaryTree() {
        root = null;
        size = 0;
    }

    public void insert(Integer data) {
        Node newNode = new Node(data);
        if(root == null) {
            root = newNode;
        } else {
            Node n = root;
            boolean flag = true;
            while(flag) {
                if(data.compareTo(n.data) > 0) {
                    if(n.right != null) n = n.right;
                    else {
                        n.right = newNode;
                        flag = false;
                    }
                } else {
                    if(n.left != null) n = n.left;
                    else {
                        n.left = newNode;
                        flag = false;
                    }
                }
            }
        }
    }

    public boolean search(Integer data) {
        boolean ans = false;
        Node n = root;
        while(!ans && n != null) {
            if(data.equals(n.data)) ans = true;
            else if(data.compareTo(n.data) < 0) n = n.left;
            else n = n.right;
        }
        return ans;
    }

    public static void main(String[] args) {
        SearchBinaryTree tree = new SearchBinaryTree();
        System.out.println(tree);
    }
}