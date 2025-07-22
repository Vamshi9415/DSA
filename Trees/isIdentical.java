public class isIdentical {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null){
            return true;
        }
        if(p==null || q==null){
            return false;
        }
        return ((p.val==q.val)
            && (isSameTree(p.left,q.left))
            && (isSameTree(p.right,q.right)));
    }

    // TreeNode class definition
    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        // Example trees
        TreeNode tree1 = new TreeNode(1);
        tree1.left = new TreeNode(2);
        tree1.right = new TreeNode(3);

        TreeNode tree2 = new TreeNode(1);
        tree2.left = new TreeNode(2);
        tree2.right = new TreeNode(3);

        isIdentical obj = new isIdentical();
        boolean result = obj.isSameTree(tree1, tree2);
        System.out.println("Are the trees identical? " + result);
    }
}
