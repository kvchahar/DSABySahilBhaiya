package trees.programs.binarytree;

import trees.TreeNode.TreeNode;

public class SubTreeOfAnotherTree {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null) {
            return false;
        } else if (isSameSubRoot(root, subRoot)) {
            return true;
        } else {
            return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
        }
    }

    public boolean isSameSubRoot(TreeNode root, TreeNode subRoot) {
        if (root == null || subRoot == null) {
            return root == null && subRoot == null;
        } else if (root.val == subRoot.val) {
            return isSameSubRoot(root.left, subRoot.left) && isSameSubRoot(root.right, subRoot.right);
        } else {
            return false;
        }
    }
}
