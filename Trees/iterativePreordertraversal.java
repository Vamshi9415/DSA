
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Definition for a binary tree node.
 * This class represents a single node in the binary tree.
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}


class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        // Using a Stack for iterative preorder traversal
        Stack<TreeNode> stack = new Stack<>();

        // 1. Handle the edge case of an empty tree
        if (root == null) {
            return result;
        }

        // 2. Start with the root node
        stack.push(root);

        // 3. Process nodes until the stack is empty
        while (!stack.isEmpty()) {
            // Pop the current node to "visit" it
            TreeNode node = stack.pop();
            // Add its value to the result list
            result.add(node.val);

            // 4. Push the right child first, so the left child is processed first (LIFO)
            if (node.right != null) {
                stack.push(node.right);
            }

            // 5. Push the left child last
            if (node.left != null) {
                stack.push(node.left);
            }
        }
        return result;
    }
}

/**
 * The Main class to run and test the solution.
 */
public class iterativePreordertraversal {
    public static void main(String[] args) {
        // 1. Create an instance of the Solution class
        Solution solution = new Solution();

        // 2. Construct a sample binary tree to test the traversal
        //    Tree structure:
        //        10
        //       /  \
        //      5    20
        //     / \
        //    3   7
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(20);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(7);

        // 3. Call the preorderTraversal method
        List<Integer> preorderResult = solution.preorderTraversal(root);

        // 4. Print the result
        // Expected output for the tree above is: [10, 5, 3, 7, 20]
        System.out.println("Preorder Traversal Result: " + preorderResult);

        // --- Test with an empty tree ---
        List<Integer> emptyResult = solution.preorderTraversal(null);
        System.out.println("Result for an empty tree: " + emptyResult);

        // --- Test with a tree that only has a right subtree ---
        //    Tree structure:
        //        1
        //         \
        //          2
        //         /
        //        3
        TreeNode rightHeavyRoot = new TreeNode(1);
        rightHeavyRoot.right = new TreeNode(2);
        rightHeavyRoot.right.left = new TreeNode(3);
        List<Integer> rightHeavyResult = solution.preorderTraversal(rightHeavyRoot);
        // Expected output: [1, 2, 3]
        System.out.println("Result for a right-heavy tree: " + rightHeavyResult);
    }
}
