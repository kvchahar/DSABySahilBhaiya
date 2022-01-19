package trees.programs;

import trees.TreeNode.TreeNode;

public class BalancedBinaryTree {
    public boolean isBalanced(TreeNode root) {
        return subTreesHeight(root) != -1;
    }

    private int subTreesHeight(TreeNode root) {

        if (root == null) {
            return 0;
        }

        int leftHeight = subTreesHeight(root.left);
        if (leftHeight == -1) return -1;
        int rightHeight = subTreesHeight(root.right);
        if (rightHeight == -1) return -1;

        if (Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        }

        return Math.max(leftHeight, rightHeight) + 1;
    }
}
