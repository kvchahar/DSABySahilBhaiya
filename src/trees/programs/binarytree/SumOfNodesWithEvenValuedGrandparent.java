package trees.programs.binarytree;

import trees.TreeNode.TreeNode;

public class SumOfNodesWithEvenValuedGrandparent {
    public int sumEvenGrandparent(TreeNode root) {
        boolean grandParent = root.val % 2 == 0;
        int[] sum = new int[1];
        grandSum(root, false, false, sum);

        return sum[0];
    }

    private void grandSum(TreeNode root, boolean parent, boolean grandParent, int[] sum) {

        if (root != null) {
            if (grandParent) {
                sum[0] += root.val;
            }
            grandSum(root.left, root.val % 2 == 0, parent, sum);
            grandSum(root.right, root.val % 2 == 0, parent, sum);
        }
    }
}
