package trees.programs.binarytree;

import trees.TreeNode.TreeNode;

public class UnivaluedBinaryTree {
    public boolean isUnivalTree(TreeNode root) {

        return isSame(root, root.val);
    }

    public boolean isSame(TreeNode root, int value) {

        if (root == null) {
            return true;
        }

        if (root.val != value) {
            return false;
        }

        boolean left = isSame(root.left, value);
        boolean right = isSame(root.right, value);

        return left && right;
    }
}
