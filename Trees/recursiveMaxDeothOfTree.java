class Node{
int data;
Node left;
Node right;

Node(int val){
    data = val;
    left = null;
    right = null;
}
}

public class recursiveMaxDeothOfTree{
    static int maxDepthOfTree(Node root){
        if(root == null){
            return 0;
        }
        int lh = maxDepthOfTree(root.left);
        int rh = maxDepthOfTree(root.right);

        return 1 + Math.max(lh, rh);
    }

    public static void main(String[] args) {
        // Example tree:
        //      1
        //     / \
        //    2   3
        //   /
        //  4
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);

        int depth = maxDepthOfTree(root);
        System.out.println("Max Depth of Tree: " + depth);
    }
}