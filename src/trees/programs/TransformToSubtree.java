package trees.programs;

import trees.TreeNode.TreeNode;

public class TransformToSubtree {
    public void toSumTree(TreeNode root){
        sumTree(root);
    }

    private int sumTree(TreeNode root){

        if(root==null){
            return 0;
        }

        int left = sumTree(root.left);
        int right = sumTree(root.right);

        int temp = root.val;

        root.val = left + right;

        return left + right + temp;

    }
}
