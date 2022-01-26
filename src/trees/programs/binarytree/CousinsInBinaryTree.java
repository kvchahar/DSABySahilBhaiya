package trees.programs.binarytree;

import trees.TreeNode.TreeNode;

public class CousinsInBinaryTree {
    // Returns true if the nodes with values 'a' and 'b' are cousins. Else returns false
    public boolean isCousins(TreeNode root, int a, int b) {
        TreeNode[] parents = {null,null};
        int[] levels = {-1,-1};

        findNodes(root,parents,levels,a,b,0,null);

        if(parents[0]!=parents[1] && levels[0]==levels[1])
            return true;

        return false;
    }

    private void findNodes(TreeNode root, TreeNode[] parents, int[] levels, int a, int b,
                           int currentLevel, TreeNode currentParent){

        if(root==null){
            return;
        }

        if(root.val==a){
            parents[0] = currentParent;
            levels[0] = currentLevel;
        }

        if(root.val==b){
            parents[1] = currentParent;
            levels[1] = currentLevel;
        }

        findNodes(root.left, parents, levels, a, b, currentLevel + 1, root);
        findNodes(root.right, parents, levels, a, b, currentLevel + 1, root);

        return;
    }
}
