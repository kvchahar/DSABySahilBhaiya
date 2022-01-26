package trees.programs.binarysearchtree;

import trees.TreeNode.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class IncreasingOrderSearchTree {
    public TreeNode increasingBST(TreeNode root) {

        List<Integer> traversal = new ArrayList<>();

        traversalInBST(traversal,root);

        TreeNode dummyNode = root = new TreeNode(-1);
        for(int value : traversal){
            dummyNode.right = new TreeNode(value);
            dummyNode = dummyNode.right;
        }

        return root.right;
    }

    private void traversalInBST(List<Integer> traversal, TreeNode root){

        if(root==null){
            return;
        }

        traversalInBST(traversal,root.left);
        traversal.add(root.val);
        traversalInBST(traversal,root.right);

        return;
    }
}
