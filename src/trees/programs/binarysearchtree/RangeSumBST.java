package trees.programs.binarysearchtree;

import trees.TreeNode.TreeNode;

public class RangeSumBST {
    public int rangeSumBST(TreeNode root, int low, int high) {
        int[] sum = new int[1];
        sumOfRange(root, low, high, sum);
        return sum[0];
    }

    private void sumOfRange(TreeNode root, int low, int high, int[] sum) {

        if (root == null) {
            return;
        }

        if (root.val <= high && root.val >= low) {
            sum[0] += root.val;
        }

        sumOfRange(root.left, low, high, sum);
        sumOfRange(root.right, low, high, sum);

        return;
    }
}
