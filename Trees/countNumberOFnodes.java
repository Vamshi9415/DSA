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
}
