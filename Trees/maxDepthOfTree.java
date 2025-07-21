import java.util.LinkedList;
import java.util.Queue;

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

public class maxDepthOfTree {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        Queue<TreeNode> q = new LinkedList<>();
        int level = 0;
        q.add(root);

        while (!q.isEmpty()) {
            int size = q.size();

            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                if (node.left != null) {
                    q.add(node.left);
                }
                if (node.right != null) {
                    q.add(node.right);
                }
                System.out.println(node.val);
            }

            System.out.println(level);
            level++;
        }
        return level;
    }

    public static void main(String[] args) {
        maxDepthOfTree solution = new maxDepthOfTree();


        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        int depth = solution.maxDepth(root);
        System.out.println("Maximum depth of the tree: " + depth);

        // Test with empty tree
        TreeNode emptyRoot = null;
        int emptyDepth = solution.maxDepth(emptyRoot);
        System.out.println("Maximum depth of empty tree: " + emptyDepth);

        // Test with single node tree
        TreeNode singleNode = new TreeNode(1);
        int singleDepth = solution.maxDepth(singleNode);
        System.out.println("Maximum depth of single node tree: " + singleDepth);
    }
}
