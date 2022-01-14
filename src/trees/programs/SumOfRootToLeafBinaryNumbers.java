package trees.programs;

import trees.TreeNode.TreeNode;

public class SumOfRootToLeafBinaryNumbers {
    public int sumRootToLeaf(TreeNode root) {
        int[] sum = new int[1];

        sum(root,"",sum);

        return sum[0];
    }

    public void sum(TreeNode root, String str,int[] sum){
        if(root.left==null && root.right==null){
            str += String.valueOf(root.val);
            sum[0]+=Integer.parseInt(str,2);
            return;
        }

        if(root.left!=null)
            sum(root.left, str + String.valueOf(root.val), sum);

        if(root.right!=null)
            sum(root.right, str + String.valueOf(root.val), sum);
        return;

    }
}
