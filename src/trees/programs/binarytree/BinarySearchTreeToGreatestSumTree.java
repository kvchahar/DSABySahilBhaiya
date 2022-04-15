package trees.programs.binarytree;

import trees.TreeNode.TreeNode;

public class BinarySearchTreeToGreatestSumTree {
    public TreeNode bstToGst(TreeNode root) {
        int[] sum = new int[1];
        greatestSum(root,sum);

        return root;
    }

    private void greatestSum(TreeNode root, int[] sum){
        if(root==null)
            return;

        greatestSum(root.right,sum);

        sum[0] += root.val;

        root.val = sum[0];

        greatestSum(root.left,sum);
    }
}