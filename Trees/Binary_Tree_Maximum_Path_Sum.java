public class Binary_Tree_Maximum_Path_Sum {
    int max = Integer.MIN_VALUE;

    int val(TreeNode root){
        if(root == null){
            return 0;
        }

        int leftpath = Math.max(0, val(root.left));
        int rightpath = Math.max(0, val(root.right));

        max = Math.max(max, root.val+leftpath+rightpath);
        return root.val+ Math.max(leftpath,rightpath);
    }
    public int maxPathSum(TreeNode root) {
        val(root);
        return max;
    }

    public static void main(String[] args) {
        // Example usage:
        // Construct a sample tree:   1
        //                         /   \
        //                        2     3
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        Binary_Tree_Maximum_Path_Sum solver = new Binary_Tree_Maximum_Path_Sum();
        int result = solver.maxPathSum(root);
        System.out.println("Maximum Path Sum: " + result);
    }
}
