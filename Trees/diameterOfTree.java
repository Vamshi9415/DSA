class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
public class diameterOfTree {
      int diameter = 0;
     int depthOfTree(TreeNode root){
        if(root == null){
            return 0;
        }

        int leftHeight = depthOfTree(root.left);
        int rightHeight = depthOfTree(root.right);

        diameter = Math.max(diameter, leftHeight + rightHeight);

        return 1 + Math.max(leftHeight, rightHeight);
     } 
    
    public int diameterOfBinaryTree(TreeNode root) {
        depthOfTree(root);
        return diameter;
    }

    public static void main(String[] args) {
        // Example tree construction
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        diameterOfTree tree = new diameterOfTree();
        int result = tree.diameterOfBinaryTree(root);
        System.out.println("Diameter of the tree: " + result);
    }
}
