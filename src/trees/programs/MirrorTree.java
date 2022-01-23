package trees.programs;

import trees.TreeNode.TreeNode;

public class MirrorTree {
    void mirror(TreeNode node) {
        mirrorTree(node);
    }

    TreeNode mirrorTree(TreeNode node){

        if(node==null){
            return null;
        }

        TreeNode left = mirrorTree(node.left);
        TreeNode right = mirrorTree(node.right);

        node.left = right;
        node.right = left;

        return node;

    }
}
