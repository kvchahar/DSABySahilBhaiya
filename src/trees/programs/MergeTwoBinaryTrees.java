package trees.programs;

import trees.TreeNode.TreeNode;

public class MergeTwoBinaryTrees {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {

        if(root1==null && root2==null){
            return null;
        }

        if(root1==null){
            return root2;
        }

        if(root2==null){
            return root1;
        }

        int sum = root1.val + root2.val;

        TreeNode newNode = new TreeNode(sum);

        newNode.left = mergeTrees(root1.left, root2.left);

        newNode.right = mergeTrees(root1.right, root2.right);

        return newNode;
    }
}

// auxiliary space -> Big-O(max(root1,root2))
// Recursive Stack Space -> Big-O(max(h1,h2))
