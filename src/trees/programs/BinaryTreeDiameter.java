package trees.programs;

import trees.TreeNode.TreeNode;

public class BinaryTreeDiameter {
    public int diameterOfBinaryTree(TreeNode root) {
        int[] diameter = new int[1];
        diameter(root,diameter);

        return diameter[0];
    }

    private int diameter(TreeNode root, int[] diameter){

        if(root==null){
            return 0;
        }

        int left = diameter(root.left, diameter);
        int right = diameter(root.right, diameter);

        diameter[0] = Math.max(diameter[0], left + right);

        return 1 + Math.max(left,right);
    }
}
