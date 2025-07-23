public class countNumberOFnodes {
    public int countNodes(TreeNode root){
        if(root == null){
            return 0;
        }
        return 1+ countNodes( root.left) +countNodes(root.right);
    }

    public int countInternalNodes(TreeNode root) {
    if (root == null || (root.left == null && root.right == null)) {
        return 0;
    }
    return 1 + countInternalNodes(root.left) + countInternalNodes(root.right);
}
public int countLeafNodes(TreeNode root) {
    if (root == null) {
        return 0;
    }
    if (root.left == null && root.right == null) {
        return 1;
    }
    return countLeafNodes(root.left) + countLeafNodes(root.right);
}

public static void main(String[] args) {
    // Example usage:
    // Construct a sample tree:
    //      1
    //     / \
    //    2   3
    //   / \
    //  4   5

    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.right = new TreeNode(3);
    root.left.left = new TreeNode(4);
    root.left.right = new TreeNode(5);

    countNumberOFnodes counter = new countNumberOFnodes();
    System.out.println("Total nodes: " + counter.countNodes(root));
    System.out.println("Internal nodes: " + counter.countInternalNodes(root));
    System.out.println("Leaf nodes: " + counter.countLeafNodes(root));
}
}
